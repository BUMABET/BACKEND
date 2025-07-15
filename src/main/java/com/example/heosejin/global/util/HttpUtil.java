package com.example.heosejin.global.util;

import com.example.heosejin.common.dto.response.ResponseDto;

public class HttpUtil {
    public static <T> ResponseDto<T> success(String message, T data) {
        return new ResponseDto<>(message, data);
    }

    public static <T> ResponseDto<T> success(String message) {
        return new ResponseDto<>(message, null);
    }
}
