/**
 * 
 */
package stockapplication;

import java.util.Vector;
public class StocksApplication {

	/**
	 * 
	 */
	StocksApplication()
	{
		mStockList = new Vector<IStock>();
	}
	
	/**
	 * @return all shares index
	 */
	double CalculateGBCEAllSharesIndex() 
	{
		double product = 1.0;

		for (int i = 0; i < mStockList.size(); i++)
		{
			double price = mStockList.elementAt(i).CalculateStockPriceFromPastMinutes();
			product*=price;
		}

		return java.lang.Math.pow(product,1.0/mStockList.size());
	}

	/**
	 * @param StockSymbol
	 * @param Type
	 * @param LastDividend
	 * @param FixedDividend
	 * @param TickerPrice
	 * @param ParValue
	 * @return
	 */
	Stock AddStock(String StockSymbol, IStock.StockType Type, double LastDividend, double FixedDividend, double TickerPrice, double ParValue)
	{
		Stock p_stock = new Stock(StockSymbol, Type, LastDividend, FixedDividend, TickerPrice, ParValue);

		mStockList.add(p_stock);

		return p_stock;
	}

	/**
	 * 
	 */
	void ListStocks()
	{
		for (int i = 0; i < mStockList.size(); i++)
		{
			System.out.printf("%s %2f\n", mStockList.elementAt(i).GetmSymbol(),
			mStockList.elementAt(i).CalculateDividendYield());
		}
	}
	
    private Vector<IStock> mStockList;

}
