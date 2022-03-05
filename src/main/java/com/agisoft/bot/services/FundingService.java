package com.agisoft.bot.services;

import com.agisoft.bot.exchanges.ExchangeClient;
import com.agisoft.bot.model.Deal;
import com.agisoft.bot.model.Funding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FundingService {

    @Value("#{'${symbols}'.split(',')}")
    private List<String> symbols;

    private List<ExchangeClient> exchanges;

    //key = symbol, value = list of funding with exchange name.
    private Map<String, List<Funding>> funding = new HashMap<>();

    @Autowired
    public FundingService(final List<ExchangeClient> exchanges) {
        this.exchanges = exchanges;
    }


    public void collectFunding() {
        for (ExchangeClient exchange : exchanges) {
            final Map<String, Funding> exchangeFunding = exchange.getFunding();
            for (String exchangeSymbol : exchangeFunding.keySet()) {
                List<Funding> existingFundingForSymbol = funding.get(exchangeSymbol);
                final Funding f = exchangeFunding.get(exchangeSymbol);
                if (existingFundingForSymbol != null) {
                    existingFundingForSymbol.add(f);
                } else {
                    existingFundingForSymbol = new ArrayList<>();
                    existingFundingForSymbol.add(f);
                }
                existingFundingForSymbol.sort(Comparator.naturalOrder());
                funding.put(exchangeSymbol, existingFundingForSymbol);
            }
        }
        System.out.println(funding.get("BTC"));
    }

    public Deal findSymbolToTrade() {
        Deal deal = null;
        Map<String, Double> pairsToTrade = new TreeMap<>();
        for (Map.Entry<String, List<Funding>> funding : funding.entrySet()) {
            final String symbol = funding.getKey();
            final List<Funding> values = funding.getValue();
            final Funding lowest = values.get(0);
            final Funding highest = values.get(values.size() - 1);
            final Double delta = Math.abs(lowest.getRate() - highest.getRate());

            if (deal != null) {
                final Double oldDelta = deal.getDelta();
                if (delta > oldDelta) {
                    deal = new Deal(symbol, delta, lowest, highest);
                }
            } else {
                deal = new Deal(symbol, delta, lowest, highest);
            }


            pairsToTrade.put(symbol, delta);
        }
        return deal;
    }
}
