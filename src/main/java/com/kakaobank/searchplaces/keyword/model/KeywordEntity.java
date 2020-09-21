package com.kakaobank.searchplaces.keyword.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "keyword")
public class KeywordEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String keyword;

    @Column(nullable = false)
    private Long count;

    @Builder
    public KeywordEntity(Long id, String keyword, Long count) {
        this.id = id;
        this.keyword = keyword;
        this.count = count;
    }
}
