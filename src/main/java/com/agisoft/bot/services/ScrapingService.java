package com.agisoft.bot.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScrapingService {


    public void scrape() {
        try {
            // Here we create a document object and use JSoup to fetch the website
//            Document doc = Jsoup.connect("https://www.bybt.com/FundingRate").get();

            // With the document fetched, we use JSoup's title() method to fetch the title
//            System.out.printf("Title: %s\n", doc.title());
//            u-symbol-list
            //bybt-fr-symbol-solid
//
////            bybt-fr-solid
//            Elements symbols = doc.getElementsByClass("bybt-fr-symbol-solid");
////            bybt-fr-solid u-ex-title


            Document doc = Jsoup.connect("https://www.bybt.com/funding/BTC").get();
            Elements fundingE = doc.getElementsByClass("ivu-table-row");
            Elements exchanges = doc.getElementsByClass("text-center");

//            List<String> symbolsTxt = new ArrayList<>();
//            List<String> exchangesTxt = new ArrayList<>();
            List<String> funding = new ArrayList<>();


//            for (Element symbol : symbols) {
//                final Elements a = symbol.getElementsByTag("a");
//                if (a != null && a.hasText()) {
//                    symbolsTxt.add(a.text());
//                }
//            }
//
//            for (Element exchange : exchanges) {
//                final Elements a = exchange.getElementsByTag("p");
//                if (a != null && a.hasText()) {
//                    exchangesTxt.add(a.text());
//                }
//            }

            for (Element f : fundingE) {
                funding.add(f.text());
            }

//            System.out.println(symbolsTxt);
//            System.out.println(exchangesTxt);
            System.out.println(funding);
            // In case of any IO errors, we want the messages written to the console
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
