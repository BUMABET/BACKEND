package com.example.heosejin.domain.auth.service;

import com.example.heosejin.common.dto.response.TokenSet;
import com.example.heosejin.domain.auth.dto.response.GoogleTokenResponse;
import com.example.heosejin.domain.auth.dto.response.GoogleUrlResponse;
import com.example.heosejin.domain.auth.dto.response.GoogleUserInfoResponse;
import com.example.heosejin.domain.user.model.User;
import com.example.heosejin.domain.user.service.UserService;
import com.example.heosejin.global.config.properties.GoogleOauthProperties;
import com.example.heosejin.global.fegin.GoogleOauthFeign;
import com.example.heosejin.global.fegin.GoogleUserInfoFeign;
import com.example.heosejin.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final GoogleOauthFeign googleOauthFeign;
    private final GoogleUserInfoFeign googleUserInfoFeign;
    private final GoogleOauthProperties googleOauthProperties;
    private final UserService userService;
    private final JwtProvider jwtProvider;

    public TokenSet login(String code, String state) {
        GoogleTokenResponse googleTokenResponse = getGoogleToken(code);
        String accessToken = googleTokenResponse.accessToken();

        GoogleUserInfoResponse googleUserInfoResponse = googleUserInfoFeign.getUserInfo(accessToken);
        User user = userService.googleLogin(googleUserInfoResponse);

        String email = user.getEmail();
        String grade = user.getGrade();
        TokenSet tokenSet = jwtProvider.makeToken(email, grade);
        return tokenSet;
    }

    private GoogleTokenResponse getGoogleToken(String code) {
        String clientId = googleOauthProperties.getClientId();
        String secretKey = googleOauthProperties.getSecretKey();
        String redirectUri = googleOauthProperties.getRedirectUri();

        GoogleTokenResponse googleTokenResponse = googleOauthFeign.getToken(
                code,
                clientId,
                secretKey,
                redirectUri,
                "Authorization_code"
        );
        return googleTokenResponse;
    }

}
