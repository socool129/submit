package com.kakaobank.webapp.searchplace.keyword.service;

import com.kakaobank.webapp.searchplace.keyword.model.KeywordDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface KeywordService {
    public Long updateCount(String keyword);
    public List<KeywordDto> getPopularKeywordsList() throws Exception;
}
