package com.kakaobank.searchplaces.controller;

import com.kakaobank.searchplaces.auth.model.MemberDto;
import com.kakaobank.searchplaces.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    @Autowired
    private UserService userService;

    // 테스트용 페이지 start - 회원가입, 로그인, 로그아웃
    // 오로지 테스트만을 위한 기능들이며 잘 못 사용되는 경우에 대한 검증 보류
    @GetMapping("/index")
    public String index() {
        // 테스트용 유저 생성
        userService.createTestUser();
        return "html/index";
    }

    // 회원가입 페이지
    @GetMapping("/signup")
    public String dispSignup() {
        return "html/signup";
    }

    // 회원가입 처리
    @PostMapping("/signup")
    public String execSignup(MemberDto memberDto) {
        if(userService.joinUser(memberDto) != -1) {
            return "html/index";
        }

        return "redirect:/user/login";
    }
    // 테스트용 페이지 end - 회원가입, 로그인, 로그아웃

    // 메인 페이지
    @GetMapping("/")
    public String mainDisp() {
        // 테스트용 유저 생성
        userService.createTestUser();

        return "html/login_template";
    }

    // 로그인 페이지
    @GetMapping("/user/login")
    public String dispLogin() {
        // 테스트용 유저 생성
        userService.createTestUser();
        return "html/login_template";
    }

    // 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "html/denied";
    }


    // 로그인 성공 후 첫 화면
    // 기능상 MAP으로 디렉토리 분리해야하나 관련 페이지가 하나인 관계로 임시 통합
    @GetMapping("/user/map")
    public String dispMap() { return "html/kakaoMap"; }

}