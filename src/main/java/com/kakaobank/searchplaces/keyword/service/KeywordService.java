package com.kakaobank.searchplaces.keyword.service;

import com.kakaobank.searchplaces.keyword.model.KeywordDto;

import java.util.List;

public interface KeywordService {
    public Long updateCount(String keyword);
    public List<KeywordDto> getPopularKeywordsList() throws Exception;
}
