package com.example.heosejin.global.fegin;

import com.example.heosejin.domain.auth.dto.response.GoogleUserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "google-userinfo", url = "https://openidconnect.googleapis.com")
public interface GoogleUserInfoFeign {

    @GetMapping("/v1/userinfo")
    GoogleUserInfoResponse getUserInfo(@RequestHeader("Authorization") String bearerToken);
}
