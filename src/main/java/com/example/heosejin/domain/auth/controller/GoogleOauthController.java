package com.example.heosejin.domain.auth.controller;

import com.example.heosejin.common.dto.response.ResponseDto;
import com.example.heosejin.common.dto.response.TokenSet;
import com.example.heosejin.domain.auth.dto.response.GoogleUrlResponse;
import com.example.heosejin.domain.auth.service.AuthService;
import com.example.heosejin.domain.auth.service.GoogleLinkService;
import com.example.heosejin.global.util.HttpUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class GoogleOauthController {
    private final AuthService authService;
    private final GoogleLinkService googleLinkService;

    @GetMapping("/auth/google")
    public ResponseEntity<ResponseDto<GoogleUrlResponse>> google() {
        String state = UUID.randomUUID().toString();
        GoogleUrlResponse urlResponse = googleLinkService.url(state);
        ResponseDto<GoogleUrlResponse> responseDto = HttpUtil.success("get google link", urlResponse);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/auth/google/callback")
    public void login(@RequestParam String code, @RequestParam String state, HttpServletResponse response) throws IOException {
        TokenSet tokenSet = authService.login(code, state);
        String redirectUrl = "http://10.129.57.28:3000/oauth/success"
                + "?accessToken=" + tokenSet.accessToken()
                + "&refreshToken=" + tokenSet.refreshToken();
        response.sendRedirect(redirectUrl);
    }
}
