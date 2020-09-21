package com.kakaobank.webapp.searchplace.controller;

import com.kakaobank.webapp.searchplace.keyword.model.AjaxResponseBody;
import com.kakaobank.webapp.searchplace.keyword.model.KeywordDto;
import com.kakaobank.webapp.searchplace.keyword.service.KeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class KeywordController {
    @Autowired
    KeywordService keywordService;

    // 검색어 업데이트
    @PostMapping("user/keyword")
    public void updateKeywordViaAjax(@RequestBody String keyword){
        keywordService.updateCount(keyword);
    }

    @PostMapping("user/popularkeywords")
    public ResponseEntity<?> getPopularKeywordsList() throws Exception {
        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        List<KeywordDto> keywordDtos;

        keywordDtos = keywordService.getPopularKeywordsList();
        if(keywordDtos.isEmpty()) {
            ajaxResponseBody.setMsg("Can't get any data");
        }
        else {
            ajaxResponseBody.setMsg("Success");
        }
        ajaxResponseBody.setResult(keywordDtos);

        return ResponseEntity.ok(ajaxResponseBody);
    }

}
