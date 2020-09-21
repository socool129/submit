package com.kakaobank.webapp.searchplace.keyword.repo;

import com.kakaobank.webapp.searchplace.keyword.model.KeywordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KeywordRepo extends JpaRepository<KeywordEntity, Long> {
    Optional<KeywordEntity> findByKeyword(String keyword);
    List<KeywordEntity> findTop10ByOrderByCountDesc();
}