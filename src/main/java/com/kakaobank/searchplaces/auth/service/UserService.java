package com.kakaobank.searchplaces.auth.service;

import com.kakaobank.searchplaces.auth.model.MemberDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserService extends UserDetailsService {
    public UserDetails loadUserByUsername(String memberId);
    public PasswordEncoder passwordEncoder() throws Exception;
    public Long joinUser(MemberDto memberDto);
    public void createTestUser();
}
