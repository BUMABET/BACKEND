package com.example.heosejin.common.dto.response;

public record ResponseDto<T> (
        String message,
        T data
) {
}
