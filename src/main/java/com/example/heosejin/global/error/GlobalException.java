package com.example.heosejin.global.error;

import com.example.heosejin.global.error.ErrorCode.ErrorCode;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GlobalException extends RuntimeException {
    private ErrorCode errorCode;

}
