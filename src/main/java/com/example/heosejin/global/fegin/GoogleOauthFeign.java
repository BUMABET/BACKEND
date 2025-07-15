package com.example.heosejin.global.fegin;

import com.example.heosejin.domain.auth.dto.response.GoogleTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "google-oauth", url = "https://oauth2.googleapis.com")
public interface GoogleOauthFeign {

    @PostMapping(value = "/token", consumes = "application/x-www-form-urlencoded")
    GoogleTokenResponse getToken(
            @RequestParam("code") String code,
            @RequestParam("client_id") String clientId,
            @RequestParam("client_secret") String clientSecret,
            @RequestParam("redirect_uri") String redirectUri,
            @RequestParam("grant_type") String grantType
    );
}
