package com.kakaobank.webapp.searchplace.auth.service;

import com.kakaobank.webapp.searchplace.auth.model.MemberDto;
import com.kakaobank.webapp.searchplace.auth.model.MemberEntity;
import com.kakaobank.webapp.searchplace.auth.model.Role;
import com.kakaobank.webapp.searchplace.auth.repo.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service(value = "userServiceImpl")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private MemberRepo memberRepo;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public Long joinUser(MemberDto memberDto) {
        if(memberRepo.findByMemberId(memberDto.getMemberId()).isEmpty()) {// 비밀번호 암호화
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

            return memberRepo.save(memberDto.toEntity()).getId();
        }
        return (long)-1;
    }

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        MemberEntity memberEntity = memberRepo.findByMemberId(memberId)
                .orElseThrow(() -> new UsernameNotFoundException(memberId));

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin").equals(memberId)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(memberEntity.getMemberId(), memberEntity.getPassword(), authorities);
    }

    @Override
    public void createTestUser() {
        MemberDto memberDto;

        if(memberRepo.findByMemberId("testuser").isEmpty()) {
            memberDto = MemberDto.builder()
                    .memberId("testuser").password("testuser").build();
            this.joinUser(memberDto);
        }
        if(memberRepo.findByMemberId("kakaobank").isEmpty()) {
            memberDto = MemberDto.builder()
                    .memberId("kakaobank").password("kakaobank").build();
            this.joinUser(memberDto);
        }
    }

    @Override
    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    }

}