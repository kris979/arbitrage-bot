package com.agisoft.bot.model.ftx;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class FTXFunding {

    private String future;
    private Double rate;
    private Date time;
}
