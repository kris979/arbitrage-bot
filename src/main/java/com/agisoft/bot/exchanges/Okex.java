package com.agisoft.bot.exchanges;

import com.agisoft.bot.model.Funding;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class Okex implements ExchangeClient {

    @Override
    public Map<String, Funding> getFunding() {
        Map<String, Funding> fundingMap = new HashMap<>();
        fundingMap.put("BTC", new Funding(Exchange.OkEx, 0.05d, new Date(LocalDateTime.now()
                                                                                         .toEpochSecond(
                                                                                                 ZoneOffset.UTC))));
        return fundingMap;
    }
}
