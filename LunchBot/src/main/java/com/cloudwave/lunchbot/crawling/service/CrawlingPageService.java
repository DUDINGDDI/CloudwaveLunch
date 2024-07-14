package com.cloudwave.lunchbot.crawling.service;

import com.cloudwave.lunchbot.crawling.dto.request.PageCodeDto;

import java.io.IOException;

public interface CrawlingPageService {

    PageCodeDto getPageCode() throws IOException;
}
