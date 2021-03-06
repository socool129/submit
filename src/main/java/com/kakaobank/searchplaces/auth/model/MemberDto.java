package com.kakaobank.searchplaces.auth.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String memberId;
    private String password;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .memberId(memberId)
                .password(password)
                .build();
    }

    @Builder
    public MemberDto(Long id, String memberId, String password) {
        this.id = id;
        this.memberId = memberId;
        this.password = password;
    }
}