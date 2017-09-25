package stockapplication;

/**
 *
 */
public interface IStock {
	enum StockType
	{
		COMMON,
		PREFERRED,
	}
	/**
	 * @return stock symbol
	 */
	String GetmSymbol();

	/**
	 * @return dividend yield
	 */
	double CalculateDividendYield();

	/**
	 * @return pe ration
	 */
	double CalculatePERatio();

	/**
	 * @param Price
	 * @param Quantity
	 * @param Indicator
	 * @return trade
	 */
	ITrade CreateTrade(double Price, double Quantity, ITrade.TradeIndicator Indicator);

	/**
	 * @param pTrade
	 */
	void RecordTrade(ITrade pTrade);

	/**
	 * @return stock price from the last 15 minutes
	 */
	double CalculateStockPriceFromPastMinutes();
}