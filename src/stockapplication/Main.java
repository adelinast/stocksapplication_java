package stockapplication;

import stockapplication.ITrade.TradeIndicator;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StocksApplication stocks_application = new StocksApplication();
		
		Stock p_stock1 = stocks_application.AddStock("TEA", IStock.StockType.COMMON, 1, 1, 1, 100);
		ITrade p_trade1 = p_stock1.CreateTrade(100, 10, ITrade.TradeIndicator.BUY);
		
		p_stock1.RecordTrade(p_trade1);

		Stock p_stock2 = stocks_application.AddStock("IBM", IStock.StockType.COMMON, 1, 1, 1, 100);
		ITrade p_trade2 = p_stock2.CreateTrade(100, 10, TradeIndicator.BUY);
		p_stock2.RecordTrade(p_trade2);

		Stock p_stock3 = stocks_application.AddStock("GIN", IStock.StockType.PREFERRED, 8, 2, 1, 100);
		ITrade p_trade3 = p_stock3.CreateTrade(100, 10, TradeIndicator.BUY);
		p_stock3.RecordTrade(p_trade3);

		stocks_application.ListStocks();

		System.out.printf("Index %f\n", stocks_application.CalculateGBCEAllSharesIndex());
	}
}
