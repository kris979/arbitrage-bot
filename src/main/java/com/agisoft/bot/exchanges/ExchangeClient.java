package com.agisoft.bot.exchanges;

import com.agisoft.bot.model.Funding;
import com.agisoft.bot.model.ftx.FTXFunding;

import java.util.Map;

public interface ExchangeClient {

    Map<String, Funding> getFunding();
}
