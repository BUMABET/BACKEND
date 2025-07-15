package com.example.heosejin.domain.auth.dto.response;

public record GoogleUserInfoResponse(
        String sub,
        String name,
        String given_name,
        String family_name,
        String picture,
        String email,
        boolean email_verified,
        String locale
) {}
