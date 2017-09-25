package stockapplication;

import java.sql.Timestamp;

public class TimeStamp {

	private Timestamp mTimeStamp;

	/**
	 * @param timestamp
	 */
	TimeStamp(Timestamp timestamp)
	{
		SetmTimeStamp(timestamp);
	}

	/**
	 * @param minutes
	 * @return
	 */
	boolean IsPastMinutes(int minutes)
	{
		long searchTimestamp  = System.currentTimeMillis();
		long PastTimeStamp = System.currentTimeMillis() - minutes;

		if (searchTimestamp >= PastTimeStamp) {
			return true;
		}

		return false;
	}

	/**
	 * @return
	 */
	public static Timestamp GetCurrentTimeStamp()
	{
		Timestamp current_timestamp = new Timestamp(System.currentTimeMillis());
		return current_timestamp;
	}

	/**
	 * @return the mTimeStamp
	 */
	public Timestamp GetmTimeStamp() {
		return mTimeStamp;
	}

	/**
	 * @param mTimeStamp the TimeStamp to set
	 */
	public void SetmTimeStamp(Timestamp TimeStamp) {
		this.mTimeStamp = TimeStamp;
	}
}
