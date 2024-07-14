package com.cloudwave.lunchbot.crawling.controller;

import com.cloudwave.lunchbot.crawling.service.CrawlingPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/crawling")
public class CrawlingController {

    private final CrawlingPageService crawlingPageService;

    @Autowired
    public CrawlingController(CrawlingPageService crawlingPageService) {
        this.crawlingPageService = crawlingPageService;
    }

    @GetMapping("/go")
    public void  findpage() throws IOException {
        crawlingPageService.getPageCode();
    }
}
