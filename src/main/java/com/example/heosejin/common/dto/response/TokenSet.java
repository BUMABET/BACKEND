package com.example.heosejin.common.dto.response;

public record TokenSet (
        String accessToken,
        String refreshToken
) {
}
