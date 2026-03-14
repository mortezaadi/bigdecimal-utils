package io.github.mortezaadi.bigdecimalutils;

import java.math.BigDecimal;

/**
 * Utility to help comparison of {@link BigDecimal}.
 * 
 * The only way to compare {@link BigDecimal} is to get result of compare
 * function of {@link BigDecimal} and compare the result with -1, 0 and 1.
 * 
 * Although it is straight forward however it lacks expressiveness and decreases
 * readability. For instance look at this line of code :
 * 
 * <pre>
 * <code>
 *     if(balance.compareTo(maxAmount) &lt; 0))
 * </code>
 * </pre>
 * 
 * the code above try to check condition "balance &lt; maxAmount". You
 * definitely spotted the problem. now imagine how hard it can be if you have to
 * read some code with a lot of {@link BigDecimal} comparison!!
 * {@link BigDecimalUtils} makes comparison of {@link BigDecimal}s more easier
 * and more readable than the comparator method. look how above code are written
 * by the help of this library.
 * 
 * <pre>
 * <code>
 *     if( is(balance).lt(maxAmount) )
 * </code>
 * </pre>
 * 
 * 
 * @author adigozalpour
 *
 */
public final class BigDecimalUtils {

	private BigDecimalUtils() {
		throw new IllegalStateException( "Utility class can not be instantiated. to start use static is() function" );
	}

	/**
	 * Entry points of {@link BigDecimalUtils}
	 *
	 * Example usage:
	 * 
	 * <pre>
	 * <code>
	 *      is(three).eq(four); //Equal
	 * 		is(two).gt(two);    //Greater than
	 * 		is(two).gte(one);   //Greater than equal
	 * 		is(three).lt(two);  //Less than
	 * 		is(three).lte(two); //Less than equal
	 * 
	 *      is(three).not().eq(four);  //Not Equal
	 * 		is(two).not().gt(two);   //Not Greater than
	 * 		is(two).not().gte(one); //Not Greater than equal
	 * 		is(three).not().lt(two);  //Not Less than
	 * 		is(three).not().lte(two); //Not Less than equal
	 * 
	 *      is(three).zero();  is(three).not().zero();
	 *      is(three).positive();  is(three).negative();
	 *      is(three).not().positive();  is(three).not().negative();
	 * </code>
	 * </pre>
	 * 
	 * @param decimal
	 *            your {@link BigDecimal}, {@link Double} or {@link Long}
	 * 
	 * @return {@link BigDecimalWrapper}
	 *
	 */
	public static BigDecimalWrapper is(BigDecimal decimal) {
		return new BigDecimalWrapper(decimal);
	}

	/**
	 * Entry points of {@link BigDecimalUtils}
	 * Example usage:
	 * 
	 * <pre>
	 * <code>
	 *      is(three).eq(four); //Equal
	 * 		is(two).gt(two);    //Greater than
	 * 		is(two).gte(one);   //Greater than equal
	 * 		is(three).lt(two);  //Less than
	 * 		is(three).lte(two); //Less than equal
	 * 
	 *      is(three).not().eq(four);  //Not Equal
	 * 		is(two).not().gt(two);   //Not Greater than
	 * 		is(two).not().gte(one); //Not Greater than equal
	 * 		is(three).not().lt(two);  //Not Less than
	 * 		is(three).not().lte(two); //Not Less than equal
	 * 
	 *      is(three).zero();  is(three).not().zero();
	 *      is(three).positive();  is(three).negative();
	 *      is(three).not().positive();  is(three).not().negative();
	 *      is(three).nullOrZero();  is(three).not().nullOrZero();
	 * </code>
	 * </pre>
	 * 
	 * @param decimal
	 *            your {@link BigDecimal}
	 * 
	 * @return {@link BigDecimalWrapper}
	 * 
	 */
	public static BigDecimalWrapper is(double decimal) {
		return is(BigDecimal.valueOf(decimal));
	}

	public static BigDecimalWrapper is(long val) {
		return is(BigDecimal.valueOf(val));
	}

	/**
	 * Entry point for {@code int} values. Delegates to {@link #is(long)}.
	 *
	 * @param val the value to wrap
	 * @return {@link BigDecimalWrapper}
	 */
	public static BigDecimalWrapper is(int val) {
		return is((long) val);
	}

}
