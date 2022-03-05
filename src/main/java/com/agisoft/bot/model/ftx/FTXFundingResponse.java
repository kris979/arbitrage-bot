package com.agisoft.bot.model.ftx;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FTXFundingResponse {

    private boolean success;
    private List<FTXFunding> result;
}
