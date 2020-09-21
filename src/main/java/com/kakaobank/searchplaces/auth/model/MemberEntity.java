package com.kakaobank.searchplaces.auth.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String memberId;

    @Column(length = 100, nullable = false)
    private String password;

    @Builder
    public MemberEntity(Long id, String memberId, String password) {
        this.id = id;
        this.memberId = memberId;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}