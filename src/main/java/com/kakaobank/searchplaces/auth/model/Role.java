package com.kakaobank.searchplaces.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {

    MEMBER("ROLE_MEMBER"),
    // Admin 확장을 위해 기본 구현
    ADMIN("ROLE_ADMIN");

    private String value;
}