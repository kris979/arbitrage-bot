package com.agisoft.bot.exchanges;

import com.agisoft.bot.model.Funding;
import com.agisoft.bot.model.ftx.FTXFundingResponse;
import com.agisoft.bot.model.ftx.FTXFunding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FTX implements ExchangeClient {

    private RestTemplate restTemplate;
    private String fundingRatesUrl = "https://ftx.com/api/funding_rates";


    @Autowired
    public FTX(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Map<String, Funding> getFunding() {

        Map<String, Funding> fundingMap = new HashMap<>();
        final ResponseEntity<FTXFundingResponse> forEntity = restTemplate.getForEntity(fundingRatesUrl,
                                                                                       FTXFundingResponse.class);
        final FTXFundingResponse body = forEntity.getBody();
        final List<FTXFunding> result = body.getResult();
        for (FTXFunding f : result) {
            String future = f.getFuture();
            final String symbol = future.substring(0, future.indexOf("-PERP"));
            fundingMap.put(symbol, Funding.convert(Exchange.FTX, f));
        }
        return fundingMap;
    }
}
