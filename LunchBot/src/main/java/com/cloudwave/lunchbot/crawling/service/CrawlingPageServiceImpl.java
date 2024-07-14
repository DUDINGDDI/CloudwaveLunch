package com.cloudwave.lunchbot.crawling.service;

import com.cloudwave.lunchbot.crawling.dto.request.PageCodeDto;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class CrawlingPageServiceImpl implements CrawlingPageService {

    @Override
    public PageCodeDto getPageCode() throws IOException {  //최신 페이지 가져오기
        jsoupCrawling("https://www.instagram.com/onnuri1002/");
        return null;
    }


    public void jsoupCrawling(String html) throws IOException { //페이지 크롤링해오기
        Document doc = Jsoup.connect(html).get();
        //ID찾기
        Elements elementss = doc.select("[id*='mount_0_0_']");

        String id = " ";
        for (Element element : elementss) {
            log.info("Element ID: {}", element.id());
            id = element.id();
        }
        //ID완성하고
        String cssQuery = "#"+id+" > div > div > div.x9f619.x1n2onr6.x1ja2u2z > div > div > div.x78zum5.xdt5ytf.x1t2pt76.x1n2onr6.x1ja2u2z.x10cihs4 > div:nth-child(2) > section > main > div > div.x9f619.xjbqb8w.x78zum5.x168nmei.x13lgxp2.x5pf9jr.xo71vjh.x1n2onr6.x1plvlek.xryxfnj.x1iyjqo2.x2lwn1j.xeuugli.xdt5ytf.xqjyukv.x1qjc9v5.x1oa3qoh.x1nhvcw1 > article > div:nth-child(1) > div > div:nth-child(1) > div:nth-child(1)";
        log.info("Element cssquery: {}",cssQuery);

        //ID를 활용해 element찾기
        Elements elements = doc.select(cssQuery);
        log.info(elements.text());

        for (Element element : elements) {
            log.info("Element HTML: {}", element.html());
            log.info("Element Text: {}", element.text());
            log.info(element.attr("href"));
        }


        // 모든 <a> 태그 중 href 속성이 있는 요소를 선택합니다.
        Elements links = doc.select("a[href]");

        // 링크의 href 값을 출력합니다.
        for (Element link : links) {
            log.info("Link: " + link.attr("href"));
        }
        log.info("끗");
    }
}
