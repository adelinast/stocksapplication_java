package stockapplication;
public class Trade implements ITrade {
	
	/**
	 * @param Price
	 * @param Quantity
	 * @param Indicator
	 * @param TimeStamp
	 */
	Trade(double Price, double Quantity, TradeIndicator Indicator, TimeStamp TimeStamp) 
	{
		SetmTimeStamp(TimeStamp);
		SetmPrice(Price);
		SetmQuantityShares(Quantity);
		SetmTradeIndicator(Indicator);
	}

	/**
	 * @return the mTimeStamp
	 */
	@Override
	public TimeStamp GetmTimeStamp() {
		return mTimeStamp;
	}

	/**
	 * @param mTimeStamp the mTimeStamp
	 */
	public void SetmTimeStamp(TimeStamp TimeStamp) {
		this.mTimeStamp = TimeStamp;
	}

	/**
	 * @return the mPrice
	 */
	@Override
	public double GetmPrice() {
		return mPrice;
	}

	/**
	 * @param mPrice the mPrice to set
	 */
	public void SetmPrice(double Price) {
		this.mPrice = Price;
	}

	/**
	 * @return the mQuantityShares
	 */
	@Override
	public double GetmQuantityShares() {
		return mQuantityShares;
	}

	/**
	 * @param mQuantityShares the mQuantityShares to set
	 */
	public void SetmQuantityShares(double QuantityShares) {
		this.mQuantityShares = QuantityShares;
	}

	/**
	 * @return the mTradeIndicator
	 */
	@Override
	public TradeIndicator GetmTradeIndicator() {
		return mTradeIndicator;
	}

	/**
	 * @param mTradeIndicator the mTradeIndicator to set
	 */
	public void SetmTradeIndicator(TradeIndicator TradeIndicator) {
		this.mTradeIndicator = TradeIndicator;
	}

	/**
	 * @param Minutes the past minutes to be considered
	 */
	@Override
	public boolean IsFromPastMinutes(int Minutes)
	{
		return mTimeStamp.IsPastMinutes(Minutes);
	}

	private TimeStamp mTimeStamp;
	private double mPrice;
	private double mQuantityShares;
	private TradeIndicator mTradeIndicator;
}
