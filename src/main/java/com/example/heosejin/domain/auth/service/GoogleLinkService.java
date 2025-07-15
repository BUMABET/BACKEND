package com.example.heosejin.domain.auth.service;

import com.example.heosejin.domain.auth.dto.response.GoogleUrlResponse;
import com.example.heosejin.global.config.properties.GoogleOauthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoogleLinkService {
    private final GoogleOauthProperties googleOauthProperties;

    public GoogleUrlResponse url(String state) {
        String url = "https://accounts.google.com/o/oauth2/v2/auth"
                + "?client_id=" + googleOauthProperties.getClientId()
                + "&redirect_uri=" + googleOauthProperties.getRedirectUri()
                + "&response_type=code"
                + "&scope=openid%20email%20profile"
                + "&access_type=offline"
                + "&prompt=consent"
                + "&state=" + state;

        return new GoogleUrlResponse(url);
    }
}
