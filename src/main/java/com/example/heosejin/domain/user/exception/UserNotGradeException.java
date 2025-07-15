package com.example.heosejin.domain.user.exception;

import com.example.heosejin.global.error.ErrorCode.ErrorCode;
import com.example.heosejin.global.error.GlobalException;

public class UserNotGradeException extends GlobalException {
    public UserNotGradeException() {
        super(ErrorCode.USER_NOT_SECOND_GRADE);
    }

    public UserNotGradeException(ErrorCode errorCode) {
        super(errorCode);
    }

    static class Holder {
        private static final UserNotGradeException INSTANCE = new UserNotGradeException();
    }

    public static UserNotGradeException getInstance() {
        return Holder.INSTANCE;
    }
}
