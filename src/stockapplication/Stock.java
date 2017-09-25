package stockapplication;

import java.sql.Timestamp;
import java.util.Vector;


public class Stock implements IStock {

	/**
	 * @param Symbol
	 * @param Type
	 * @param LastDividend
	 * @param FixedDividend
	 * @param TickerPrice
	 * @param ParValue
	 */
	public Stock(String Symbol, StockType Type, double LastDividend, double FixedDividend,
			double TickerPrice, double ParValue)
	{
		mFixedDividend = FixedDividend;
		mLastDividend = LastDividend;
		mParValue = ParValue;
		mSymbol = Symbol;
		mTickerPrice = TickerPrice;
		mType = Type;
		mTradeList = new Vector<ITrade>();
	}

	/**
	 * @return dividend yield
	 */
	@Override
	public double CalculateDividendYield()
	{
		switch(mType)
		{
		case COMMON:
			return CalculateCommonDividendYield();
		case PREFERRED:
			return CalculatePreferredDividendYield();
		default:
			break;
		}

		return 0;    	
	}

	/**
	 * @return pe ratio
	 */
	@Override
	public double CalculatePERatio()
	{
		double dividend = CalculateDividendYield();
		if (dividend == 0 || mTickerPrice == 0)
		{
			return 0;
		}

		return mTickerPrice/dividend;    	
	}

	/**
	 * @return stock symbol
	 */
	@Override
	public String GetmSymbol() {
		return mSymbol;
	}

	/**
	 * @param Price
	 * @param Quantity
	 * @param Indicator
	 * @return new trade
	 */
	@Override
	public ITrade CreateTrade(double Price, double Quantity, ITrade.TradeIndicator Indicator) {
		Timestamp current_timestamp = TimeStamp.GetCurrentTimeStamp();
		TimeStamp timestamp = new TimeStamp(current_timestamp);

		Trade trade = new Trade(Price, Quantity, Indicator, timestamp);

		return trade;
	}

	/**
	 * @param Trade
	 */
	@Override
	public void RecordTrade(ITrade Trade) {
		mTradeList.add(Trade);
	}

	/**
	 * @return stock price from the last 15 minutes
	 */
	@Override
	public double CalculateStockPriceFromPastMinutes() {
		//get all trades from the past minutes
		double productSum = 0;
		double quantitySum = 0;
		final int c_recent_minutes = FIFTEEN_MINUTES;

		for (int i = 0; i < mTradeList.size(); i++)
		{
			ITrade trade = mTradeList.elementAt(i);
			//if trade is from past minutes
			if (trade.IsFromPastMinutes(c_recent_minutes))
			{
				// sum the product tradePrice*quantity
				productSum += trade.GetmPrice() * trade.GetmQuantityShares();

				// sum the quantity
				quantitySum += trade.GetmQuantityShares();
			}
		}

		if (productSum == 0 || quantitySum == 0)
		{
			return 0;
		}

		return productSum / quantitySum;
	}

	/**
	 * @return preferred dividend yield
	 */
	private double CalculatePreferredDividendYield() {
		if (mFixedDividend == 0 || mTickerPrice == 0)
		{
			return 0;
		}

		return mFixedDividend/mTickerPrice;
	}

	/**
	 * @return common dividend yield
	 */
	private double CalculateCommonDividendYield() {
		if (mLastDividend == 0 || mTickerPrice == 0)
		{
			return 0;
		}

		return mLastDividend/mTickerPrice;
	}

	private double mFixedDividend;
	private double mLastDividend;
	@SuppressWarnings("unused")
	private double mParValue;
	private String mSymbol;
	private double mTickerPrice;
	private StockType mType;
	private Vector<ITrade> mTradeList;
	private static final int FIFTEEN_MINUTES = 15 * 60 * 1000;

}