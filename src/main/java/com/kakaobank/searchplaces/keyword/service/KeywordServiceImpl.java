package com.kakaobank.searchplaces.keyword.service;

import com.kakaobank.searchplaces.keyword.model.KeywordDto;
import com.kakaobank.searchplaces.keyword.model.KeywordEntity;
import com.kakaobank.searchplaces.keyword.repo.KeywordRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service(value = "keywordServiceImpl")
@RequiredArgsConstructor
public class KeywordServiceImpl implements KeywordService{
    @Autowired
    KeywordRepo keywordRepo;
    @Autowired
    ModelMapper modelMapper;

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Transactional
    public Long updateCount(String keyword) {
        KeywordDto keywordDto;
        Optional<KeywordEntity> keywordEntityWrapper = keywordRepo.findByKeyword(keyword);
        KeywordEntity keywordEntity = keywordEntityWrapper
                .orElse(KeywordDto.builder().keyword(keyword).count((long) 0).build().toEntity());

        keywordDto = KeywordDto.builder()
                .id(keywordEntity.getId())
                .keyword(keyword)
                .count(keywordEntity.getCount() + 1)
                .build();

        return keywordRepo.save(keywordDto.toEntity()).getId();
    }

    public List<KeywordDto> getPopularKeywordsList() throws Exception {
        List<KeywordEntity> keywordEntities = keywordRepo.findTop10ByOrderByCountDesc();
        return this.convertKeywordEntityListToDtoList(keywordEntities);
    }

    private List<KeywordDto> convertKeywordEntityListToDtoList
            (List<KeywordEntity> keywordEntities) throws Exception {

        return keywordEntities
                .stream()
                .map(e->modelMapper.map(e, KeywordDto.class))
                .collect(Collectors.toList());
    }
}
