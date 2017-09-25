/**
 * 
 */
package stockapplication;
public interface ITrade {

	enum TradeIndicator
	{
		BUY,
		SELL
	};
	/**
	 * @return the mTimeStamp
	 */
	public TimeStamp GetmTimeStamp();

	/**
	 * @return the mPrice
	 */
	public double GetmPrice();

	/**
	 * @return the mQuantityShares
	 */
	public double GetmQuantityShares();

	/**
	 * @return the mTradeIndicator
	 */
	TradeIndicator GetmTradeIndicator();

	/**
	 * @param Minutes the past minutes to be considered
	 */
	public boolean IsFromPastMinutes(int Minutes);
}
