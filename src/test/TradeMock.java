/**
 * 
 */
package test;

import stockapplication.ITrade;
import stockapplication.TimeStamp;

public class TradeMock implements ITrade {

	/**
	 * 
	 */
	public TradeMock() {
	}

	@Override
	public TimeStamp GetmTimeStamp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double GetmPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double GetmQuantityShares() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TradeIndicator GetmTradeIndicator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean IsFromPastMinutes(int Minutes) {
		// TODO Auto-generated method stub
		return true;
	}

}
