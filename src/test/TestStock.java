package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import stockapplication.Stock;
import stockapplication.IStock;

public class TestStock {

	Stock mSUT;
	TradeMock mTradeMock;

	@Before
	public void setUp() {
		mSUT = new Stock("IBM", IStock.StockType.COMMON, 100, 100, 100, 10);
		mTradeMock = new TradeMock();
	}

	@Test
	public void testCalculateDividendYield() {
		double expected_yield = 1;
		double actual_yield = mSUT.CalculateDividendYield();

		assertEquals(expected_yield, actual_yield, 0);
	}

	@Test
	public void testCalculatePERatio() {
		double expected_pe = 100;
		double actual_pe = mSUT.CalculatePERatio();

		assertEquals(expected_pe, actual_pe, 0);
	}

	@Test
	public void testGetmSymbol() {
		assertEquals("IBM", mSUT.GetmSymbol());
	}

	@Test
	public void testCalculateStockPriceFromPastMinutes() {
		//ARRANGE
		double expected_price = 0;
		mSUT.RecordTrade(mTradeMock);

		//ACT
		double actual_price = mSUT.CalculateStockPriceFromPastMinutes();

		//ASSERT
		assertEquals(expected_price, actual_price, 0);
	}
}
