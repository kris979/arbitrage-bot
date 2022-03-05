package com.agisoft.bot.services;


import com.agisoft.bot.model.bybt.BybtResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class BybtService {

    private RestTemplate restTemplate;


    @Autowired
    public BybtService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public BybtResponse getFunding() {
        final ResponseEntity<BybtResponse> forEntity = restTemplate.getForEntity(
                "https://open-api.bybt.com/api/pro/v1/futures/funding_rates_chart?type=U&symbol=BTC",
                BybtResponse.class);
        final BybtResponse body = forEntity.getBody();
//        log.info(body.toString());
        return body;
    }
}
