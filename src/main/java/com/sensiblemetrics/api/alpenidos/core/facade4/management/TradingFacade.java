package com.sensiblemetrics.api.alpenidos.core.facade4.management;

import com.sensiblemetrics.api.alpenidos.core.facade4.model.TradeDetails;
import com.sensiblemetrics.api.alpenidos.core.facade4.system.ReconciliationSystem;
import com.sensiblemetrics.api.alpenidos.core.facade4.system.RegulatorySystem;
import com.sensiblemetrics.api.alpenidos.core.facade4.system.RiskAndControlSystem;
import com.sensiblemetrics.api.alpenidos.core.facade4.system.SalesAndMarketingSystem;
import com.sensiblemetrics.api.alpenidos.core.facade4.system.SettlementSystem;

/**
 * The trading facade.
 * <p>
 * Use Case: Imagine a trader has clicked on the Buy button and the Exchange UI component is about to trigger the trade...
 */
public class TradingFacade {

    /**
     * Without this facade, the Exchange UI component would have to know about and call all the different subsystems to execute the trade.... zzzz.... ;-)
     * <p>
     * This example is <em>massively</em> simplified, but you get the idea!
     */
    public void executeBuyOrder(final TradeDetails trade) {
        final TradingEngine tradingEngine = new TradingEngine();
        tradingEngine.fillBuyOrder(trade);
        tradingEngine.fillSellOrder(trade);

        final MarketMaker marketMaker = new MarketMaker();
        marketMaker.updateMarketMakingStrategy(trade);

        final ReconciliationSystem recoSystem = new ReconciliationSystem();
        recoSystem.balanceTheExchangeBooks(trade);

        final RiskAndControlSystem riskAndControl = new RiskAndControlSystem();
        riskAndControl.updateClientCreditScore(trade);

        final SettlementSystem settlements = new SettlementSystem();
        settlements.settle(trade);

        final RegulatorySystem regs = new RegulatorySystem();
        regs.auditTrade(trade);

        final SalesAndMarketingSystem sales = new SalesAndMarketingSystem();
        sales.updateCampaignBooks(trade);
    }
}
