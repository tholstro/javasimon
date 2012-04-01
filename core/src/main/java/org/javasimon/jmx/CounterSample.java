package org.javasimon.jmx;

import java.beans.ConstructorProperties;

/**
 * Value object for retrieving data from Counter Simon. Basically, it's
 * {@link org.javasimon.CounterSample} with added JMX capabilities to be return as object via
 * MXBean method.
 * <p/>
 * Example:
 * <pre>
 * SimonMXBean simon = JMX.newMXBeanProxy(..., new ObjectName("domain:type=Simon"), SimonMXBean.class);
 * CounterSample = simon.getCounterSample("simon.counter");
 * </pre>
 *
 * @author Radovan Sninsky
 * @since 2.0
 */
public final class CounterSample extends org.javasimon.CounterSample {

	/**
	 * JMX constructor. Constructor used by JMX client code to initialize all properties of object
	 * from composite data object.
	 *
	 * @param name Simon's name
	 * @param note note (provided optionally)
	 * @param firstUsage first usage ms timestamp
	 * @param lastUsage last usage ms timestamp
	 * @param lastReset last reset ms timestamp
	 * @param counter actual counter value
	 * @param min minimal counter value
	 * @param max maximal counter value
	 * @param minTimestamp time when counter reached minimal value
	 * @param maxTimestamp time when counter reached maximal value
	 * @param incSum sum of all increments
	 * @param decSum sum of all decrements
	 */
	@ConstructorProperties({"name", "note", "firstUsage", "lastUsage", "lastReset", "counter", "min",
		"max", "minTimestamp", "maxTimestamp", "incrementSum", "decrementSum"})
	public CounterSample(String name, String note, long firstUsage, long lastUsage, long lastReset, long counter,
		long min, long max, long minTimestamp, long maxTimestamp, long incSum, long decSum)
	{
		setName(name);
		setNote(note);
		setFirstUsage(firstUsage);
		setLastUsage(lastUsage);
		setLastReset(lastReset);

		setCounter(counter);
		setMin(min);
		setMax(max);
		setMinTimestamp(minTimestamp);
		setMaxTimestamp(maxTimestamp);
		setIncrementSum(incSum);
		setDecrementSum(decSum);
	}

	/**
	 * Internall, framework constructor for Simon MBean implementation to initialize all properties
	 * by sample obtained from Simon.
	 *
	 * @param sample sample object obtained from Counter Simon
	 */
	CounterSample(org.javasimon.CounterSample sample) {
		setNote(sample.getNote());
		setFirstUsage(sample.getFirstUsage());
		setLastUsage(sample.getLastUsage());
		setLastReset(sample.getLastReset());

		setCounter(sample.getCounter());
		setMin(sample.getMin());
		setMax(sample.getMax());
		setMinTimestamp(sample.getMinTimestamp());
		setMaxTimestamp(sample.getMaxTimestamp());
		setIncrementSum(sample.getIncrementSum());
		setDecrementSum(sample.getDecrementSum());
	}
}