package com.example.heosejin.domain.user.model;

import com.example.heosejin.domain.user.model.type.Grade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    @Column(unique = true)
    private String email;
    private Grade grade;

    public String getGrade() {
        return this.grade.toString();
    }

    public static User of(String name, String email, Grade grade) {
        return User.builder()
                .name(name)
                .email(email)
                .grade(grade)
                .build();
    }
}
