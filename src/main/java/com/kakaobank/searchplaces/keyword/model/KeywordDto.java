package com.kakaobank.searchplaces.keyword.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class KeywordDto {
    private Long id;
    private String keyword;
    private Long count;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public KeywordEntity toEntity(){
        return KeywordEntity.builder()
                .id(id)
                .keyword(keyword)
                .count(count)
                .build();
    }

    @Builder
    public KeywordDto(Long id, String keyword, Long count) {
        this.id = id;
        this.keyword = keyword;
        this.count = count;
    }
}
