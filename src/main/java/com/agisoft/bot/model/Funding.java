package com.agisoft.bot.model;

import com.agisoft.bot.exchanges.Exchange;
import com.agisoft.bot.model.ftx.FTXFunding;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Funding implements Comparable<Funding> {
    private Exchange exchange;
    private Double rate;
    private Date time;

    public static Funding convert(final Exchange exchange, final FTXFunding funding) {
        return new Funding(exchange, funding.getRate(), funding.getTime());
    }

    @Override
    public int compareTo(final Funding o) {
        return rate.compareTo(o.getRate());
    }
}
