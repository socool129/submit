package com.kakaobank.webapp.searchplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchplaceApplication {
    public static void main(String[] args) {
        String test = org.springframework.core.SpringVersion.getVersion();
        System.out.println(test);
        SpringApplication.run(SearchplaceApplication.class, args);
    }

}
