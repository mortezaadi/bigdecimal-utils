package ir.cafebabe.math.utils;

import java.math.BigDecimal;

/**
 * Utility to make comparison of {@link BigDecimal} easier.
 * 
 * The only way to compare {@link BigDecimal} is to get result of compare
 * function of {@link BigDecimal} and compare the result with -1, 0 and 1.
 * 
 * Although it is straight forward however it lacks expressiveness and decreases
 * readability. For instance look at this line of code :
 * 
 * <pre>
 * <code>
 *     if(balance.compareTo(maxAmount) < 0))
 * </code>
 * </pre>
 * 
 * the code above try to check condition "balance &lt; maxAmount". You
 * definitely spotted the problem. now imagine how hard it can be if you have to
 * read some code with a lot of {@link BigDecimal} comparison!! </b>
 * {@link BigDecimalUtils} makes comparison of {@link BigDecimal}s more easier
 * and more readable. look how above code are written by the help of this
 * library.
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
public class BigDecimalUtils {

	private BigDecimalUtils() {
	}

	/**
	 * Entry point of {@link BigDecimalUtils} <br/>
	 * <br/>
	 * Example usage:
	 * 
	 * <pre>
	 * <code>
	 *      is(three).eq(four); //Equal
	 * 		is(two).gt(two);    //Greater than
	 * 		is(two).gte(one);   //Greater than equal
	 * 		is(three).lt(two);  //Less than
	 * 		is(three).lte(two); //Less than equal
	 * </code>
	 * </pre>
	 * 
	 * @param decimal
	 *            your {@link BigDecimal}
	 * @return
	 */
	public static BigDecimalWrapper is(BigDecimal decimal) {

		return new BigDecimalWrapper(decimal);
	}

	/**
	 * @param dbl
	 *            double value
	 * @return {@link BigDecimalWrapper}
	 * @see #is(BigDecimal)
	 */
	public static BigDecimalWrapper is(double dbl) {
		return is(BigDecimal.valueOf(dbl));
	}

	/**
	 * wrapper of {@link BigDecimal} simplifies {@link BigDecimal} comparison
	 * easer
	 * 
	 * @author adigozalpour
	 *
	 */
	public static class BigDecimalWrapper {

		private final BigDecimal bigDecimal;

		public BigDecimalWrapper(BigDecimal bigDecimal) {
			this.bigDecimal = bigDecimal;
		}

		/**
		 * Checks whether input argument is <i><b> equal </b></i> to the provided
		 * {@link BigDecimal} or not;
		 * 
		 * @param decimal value to compare
		 * @return {@link Boolean} value
		 */
		public boolean eq(BigDecimal decimal) {
			return bigDecimal.compareTo(decimal) == 0;
		}

		/**
		 * Checks whether input argument is <i><b> equal </b></i> to the provided
		 * {@link BigDecimal} or not;
		 * 
		 * @param decimal value to compare
		 * @return {@link Boolean} value
		 */
		public boolean eq(double decimal) {
			return eq(BigDecimal.valueOf(decimal));
		}

		/**
		 * Checks whether input argument is <i><b> greater than </b></i> to the provided
		 * {@link BigDecimal} or not;
		 * 
		 * @param decimal value to compare
		 * @return {@link Boolean} value
		 */
		public boolean gt(BigDecimal decimal) {
			return bigDecimal.compareTo(decimal) > 0;
		}

		/**
		 * Checks whether input argument is <i><b> greater than </b></i> to the provided
		 * {@link BigDecimal} or not;
		 * 
		 * @param decimal value to compare
		 * @return {@link Boolean} value
		 */
		public boolean gt(double decimal) {
			return gt(BigDecimal.valueOf(decimal));
		}

		/**
		 * Checks whether input argument is <i><b> greater than equal </b></i> to the provided
		 * {@link BigDecimal} or not;
		 * 
		 * @param decimal value to compare
		 * @return {@link Boolean} value
		 */
		public boolean gte(BigDecimal decimal) {
			return bigDecimal.compareTo(decimal) >= 0;
		}

		/**
		 * Checks whether input argument is <i><b> greater than equal </b></i> to the provided
		 * {@link BigDecimal} or not;
		 * 
		 * @param decimal value to compare
		 * @return {@link Boolean} value
		 */
		public boolean gte(double decimal) {
			return gte(BigDecimal.valueOf(decimal));
		}

		/**
		 * Checks whether input argument is <i><b> less than </b></i> to the provided
		 * {@link BigDecimal} or not;
		 * 
		 * @param decimal value to compare
		 * @return {@link Boolean} value
		 */
		public boolean lt(BigDecimal decimal) {
			return bigDecimal.compareTo(decimal) < 0;
		}

		/**
		 * Checks whether input argument is <i><b> less than </b></i> to the provided
		 * {@link BigDecimal} or not;
		 * 
		 * @param decimal value to compare
		 * @return {@link Boolean} value
		 */
		public boolean lt(double decimal) {
			return lt(BigDecimal.valueOf(decimal));
		}

		/**
		 * Checks whether input argument is <i><b> less than equal </b></i> to the provided
		 * {@link BigDecimal} or not;
		 * 
		 * @param decimal value to compare
		 * @return {@link Boolean} value
		 */
		public boolean lte(BigDecimal decimal) {
			return bigDecimal.compareTo(decimal) <= 0;
		}

		/**
		 * Checks whether input argument is <i><b> less than equal </b></i> to the provided
		 * {@link BigDecimal} or not;
		 * 
		 * @param decimal value to compare
		 * @return {@link Boolean} value
		 */
		public boolean lte(double decimal) {
			return lte(BigDecimal.valueOf(decimal));
		}

	}
}
