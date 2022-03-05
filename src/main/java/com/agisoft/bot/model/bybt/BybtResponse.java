package com.agisoft.bot.model.bybt;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class BybtResponse {

    @lombok.Data
    @NoArgsConstructor
    public class Data {
        private List<Date> dateList;
        private Map<String, List<Double>> dataMap;
        private Map<String, List<Double>> frDataMap;
        private List<Double> priceList;
    }

    private Integer code;
    private String msg;
    private Data data;
    private Boolean success;

    public List<Pair<Date, Double>> getFundingForExchange(String exchange) {
        List<Pair<Date, Double>> funding = new ArrayList<>();
        final List<Double> fundingAmount = data.getDataMap().get(exchange);
        final List<Date> dates = data.getDateList();
        for (int index = 0; index < dates.size(); index++) {
            funding.add(Pair.of(dates.get(index), fundingAmount.get(index)));
        }
        return funding;
    }

}
