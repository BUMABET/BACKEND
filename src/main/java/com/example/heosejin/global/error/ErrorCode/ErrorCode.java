package com.example.heosejin.global.error.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    USER_ALEARDY_EXSISTS(400, "user already exsists"),
    USER_NOT_SECOND_GRADE(400, "user not grade"),;
    Integer status;
    String message;

}
