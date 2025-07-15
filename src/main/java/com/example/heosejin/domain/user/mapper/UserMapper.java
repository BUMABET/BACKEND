package com.example.heosejin.domain.user.mapper;

import com.example.heosejin.domain.auth.dto.response.GoogleUserInfoResponse;
import com.example.heosejin.domain.user.exception.UserNotGradeException;
import com.example.heosejin.domain.user.model.User;
import com.example.heosejin.domain.user.model.type.Grade;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(GoogleUserInfoResponse googleUserInfoResponse) {
        String name = googleUserInfoResponse.name();
        String email = googleUserInfoResponse.email();
        Grade grade = grade(email);

        return User.of(name, email, grade);
    }

    private Grade grade(String email) {
            switch (email.substring(0, 2)) {
                case "24":
                    return Grade.TWO_GRADE;
                case "25":
                    return Grade.FIRST_GRADE;
                default:
                    throw UserNotGradeException.getInstance();
        }
    }
}
