package com.kakaobank.webapp.searchplace.keyword.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AjaxResponseBody {
    List<KeywordDto> result;
    String msg;
}
