package technion.ee.softlab.qroom.QRoom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;


/**
 * The Class GlobalHelper. A Singleton which provides global functions.
 */
public class GlobalHelper {
	private static GlobalHelper m_instance = new GlobalHelper();
	private GlobalHelper() {}
	public static GlobalHelper instance() {
		return m_instance;
	}
	
	/**
	 * Gets the full education hour type.
	 *
	 * @param p_type the partial type of education hour
	 * @return the full education hour type
	 */
	public String getFullEducationHourType(String p_type){
		String type;
		if (p_type.equals("l"))
		{
			type = "Lecture";	
		} else if (p_type.equals("t"))
		{
			type = "Tutorial";
		} else if (p_type.equals("w"))
		{
			type = "Workshop";
		} else
		{
			type = "Unknown";
		}
		return type;
	}
	

	/**
	 * Gets the full Library/Farm type.
	 *
	 * @param p_type the partial Library/Farm type.
	 * @return the full Library/Farm type.
	 */
	public String getFullLibFarmType(String p_type){
		String type;
		if (p_type.equals("l"))
		{
			type = "Library";	
		} else if (p_type.equals("f"))
		{
			type = "Farm";
		} else
		{
			type = "Unknown";
		}
		return type;
	}
	
	
	//gets a full name of dayOfWeek from a number
	/**
	 * Gets the day of week name from a number.
	 * example: 5 = Thursday
	 *
	 * @param p_dayOfWeek the day of week
	 * @return the full name of the day (week)
	 */
	public String getDayOfWeek(int p_dayOfWeek)	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, p_dayOfWeek);
		DateFormat df = new SimpleDateFormat("EEEE");
		String dayOfWeek = df.format(calendar.getTime());
		return dayOfWeek;
	}
	
	/**
	 * Gets the short time string from a full time string, without seconds.
	 * Example 15:35:00 > 15:35
	 * @param p_time the lont time string
	 * @return the short time string
	 */
	public String getShortTimeString(String p_time){
		String[] separated = p_time.split(":");
		return String.format("%s:%s", separated[0],separated[1]);
	}
	
	/**
	 * Gets the underlined string instance.
	 *
	 * @param p_string the regular string
	 * @return the underlined string
	 */
	public SpannableString getUnderlinedString(String p_string) {
		SpannableString underlinedString = new SpannableString(p_string);
		underlinedString.setSpan(new UnderlineSpan(), 0, underlinedString.length(), 0);
		return underlinedString;
	}
}