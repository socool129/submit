package com.kakaobank.webapp.searchplace.controller;

import com.kakaobank.webapp.searchplace.auth.model.MemberDto;
import com.kakaobank.webapp.searchplace.auth.repo.MemberRepo;
import com.kakaobank.webapp.searchplace.auth.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MemberControllerTest {
    @Autowired
    UserService userService;
    @Autowired
    MemberRepo memberRepo;

    @Test
    // 새로운 유저 추가 테스트
    void execSignup() {
        final MemberDto memberDto = MemberDto.builder()
                .memberId("test1")
                .password("test1")
                .build();
        userService.joinUser(memberDto);
        assertNotNull(memberRepo.findByMemberId("test1"));
    }

    @Test
    // 로그인테스트
    public void dispLogin() {
        final MemberDto memberDto = MemberDto.builder()
                .memberId("test1")
                .password("test1")
                .build();
        final String memberId = memberDto.getMemberId();
        assertEquals("test1", memberId);
    }
}