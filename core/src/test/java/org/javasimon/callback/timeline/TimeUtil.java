package org.javasimon.callback.timeline;

import java.lang.reflect.Field;
import java.util.Calendar;

import org.javasimon.Split;
import org.javasimon.utils.SimonUtils;

/**
 * @author gerald
 */
public class TimeUtil {
	public static long createTimestamp(int year, int month, int day, int hour, int minutes, int seconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minutes);
		calendar.set(Calendar.SECOND, seconds);
		return calendar.getTimeInMillis();
	}

	private static void setField(Object object, String fieldName, Object fieldValue) {
		try {
			Field field = object.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(object, fieldValue);
		} catch (Exception ex) {
			throw new IllegalStateException(ex);
		}
	}

	public static void addSplit(StopwatchTimeRange timeRange, long start, long total) {
		timeRange.addSplit(start, total);
	}

	public static Split createSplit(long start, long total) {
		Split split = new Split();
		setField(split, "start", start * SimonUtils.NANOS_IN_MILLIS);
		setField(split, "total", total);
		return split;
	}

}