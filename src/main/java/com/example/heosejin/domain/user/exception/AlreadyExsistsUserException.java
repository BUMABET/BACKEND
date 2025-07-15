package com.example.heosejin.domain.user.exception;

import com.example.heosejin.global.error.ErrorCode.ErrorCode;
import com.example.heosejin.global.error.GlobalException;

public class AlreadyExsistsUserException extends GlobalException {
    public AlreadyExsistsUserException() {
        super(ErrorCode.USER_ALEARDY_EXSISTS);
    }

    static class Holder {
        private final static AlreadyExsistsUserException INSTANCE = new AlreadyExsistsUserException();
    }

    public static AlreadyExsistsUserException getInstance() {
        return Holder.INSTANCE;
    }
}
