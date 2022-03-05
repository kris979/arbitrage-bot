package com.agisoft.bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Deal {

    private String symbol;
    private Double delta;
    private Funding tradeA;
    private Funding tradeB;

}
