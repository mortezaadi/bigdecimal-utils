package io.github.mortezaadi.bigdecimalutils;

import java.math.BigDecimal;

/**
 * Wrapper of {@link BigDecimal} that simplifies comparison.
 * <p>
 * You can use short names ({@code eq}, {@code gt}, {@code gte}, {@code lt}, {@code lte})
 * or long names ({@code equal}, {@code greaterThan}, {@code greaterThanOrEqual},
 * {@code lessThan}, {@code lessThanOrEqual}); they are equivalent.
 * <p>
 * Use the fluent {@link #not()} for negated comparisons, e.g.
 * {@code is(x).not().lte(y)} or {@code is(x).not().lessThanOrEqual(y)} for "x &gt; y".
 *
 * @author adigozalpour
 */
public final class BigDecimalWrapper {

	private static final int ZERO = 0;
	private final BigDecimal bigDecimal;
	private final boolean negate;

	BigDecimalWrapper(BigDecimal bigDecimal) {
		this(bigDecimal, false);
	}

	private BigDecimalWrapper(BigDecimal bigDecimal, boolean negate) {
		this.bigDecimal = bigDecimal;
		this.negate = negate;
	}

	/**
	 * Returns a wrapper that negates the result of the next comparison.
	 * Use for fluent "not" style: {@code is(x).not().lte(y)} for "x &gt; y".
	 *
	 * @return a wrapper with negated comparison semantics
	 */
	public BigDecimalWrapper not() {
		return new BigDecimalWrapper(this.bigDecimal, !this.negate);
	}

	/**
	 * Checks whether input argument is <i><b> equal </b></i> to the provided
	 * {@link BigDecimal} or not. Null-safe: null is equal only to null.
	 *
	 * @param decimal value to compare
	 * @return {@link Boolean} true if two are equal.
	 */
	public boolean eq(BigDecimal decimal) {
		boolean result;
		if (bigDecimal == null) {
			result = (decimal == null);
		} else if (decimal == null) {
			result = false;
		} else {
			result = bigDecimal.compareTo(decimal) == ZERO;
		}
		return negate ? !result : result;
	}

	/**
	 * Checks whether input argument is <i><b> equal </b></i> to the provided
	 * {@link Double} or not;
	 *
	 * @param decimal value to compare
	 * @return {@link Boolean} true if two are equal.
	 */
	public boolean eq(double decimal) {
		return eq(BigDecimal.valueOf(decimal));
	}

	/**
	 * Checks whether input argument is <i><b> equal </b></i> to the provided
	 * {@link Long} or not;
	 *
	 * @param val value to compare
	 * @return {@link Boolean} true if two are equal.
	 */
	public boolean eq(long val) {
		return eq(BigDecimal.valueOf(val));
	}

	/**
	 * Checks whether input argument is <i><b> greater than </b></i> to the provided
	 * {@link BigDecimal} or not. Null-safe: null is not greater than any value.
	 *
	 * @param decimal value to compare
	 * @return {@link Boolean} value
	 */
	public boolean gt(BigDecimal decimal) {
		boolean result = (bigDecimal != null && decimal != null && bigDecimal.compareTo(decimal) > ZERO);
		return negate ? !result : result;
	}

	/**
	 * Checks whether input argument is <i><b> greater than </b></i> to the provided
	 * {@link Double} or not;
	 *
	 * @param decimal value to compare
	 * @return {@link Boolean} value
	 */
	public boolean gt(double decimal) {
		return gt(BigDecimal.valueOf(decimal));
	}

	/**
	 * Checks whether input argument is <i><b> greater than </b></i> to the provided
	 * {@link Long} or not;
	 *
	 * @param val value to compare
	 * @return {@link Boolean} value
	 */
	public boolean gt(long val) {
		return gt(BigDecimal.valueOf(val));
	}

	/**
	 * Checks whether input argument is <i><b> greater than equal </b></i> to the provided
	 * {@link BigDecimal} or not. Null-safe: null is not gte any value.
	 *
	 * @param decimal value to compare
	 * @return {@link Boolean} value
	 */
	public boolean gte(BigDecimal decimal) {
		boolean result = (bigDecimal != null && decimal != null && bigDecimal.compareTo(decimal) >= ZERO);
		return negate ? !result : result;
	}

	/**
	 * Checks whether input argument is <i><b> greater than equal </b></i> to the provided
	 * {@link Double} or not;
	 *
	 * @param decimal value to compare
	 * @return {@link Boolean} value
	 */
	public boolean gte(double decimal) {
		return gte(BigDecimal.valueOf(decimal));
	}

	/**
	 * Checks whether input argument is <i><b> greater than equal </b></i> to the provided
	 * {@link Long} or not;
	 *
	 * @param val value to compare
	 * @return {@link Boolean} value
	 */
	public boolean gte(long val) {
		return gte(BigDecimal.valueOf(val));
	}

	/**
	 * Checks whether input argument is <i><b> less than </b></i> to the provided
	 * {@link BigDecimal} or not. Null-safe: null is not less than any value.
	 *
	 * @param decimal value to compare
	 * @return {@link Boolean} value
	 */
	public boolean lt(BigDecimal decimal) {
		boolean result = (bigDecimal != null && decimal != null && bigDecimal.compareTo(decimal) < ZERO);
		return negate ? !result : result;
	}

	/**
	 * Checks whether input argument is <i><b> less than </b></i> to the provided
	 * {@link Double} or not;
	 *
	 * @param decimal value to compare
	 * @return {@link Boolean} value
	 */
	public boolean lt(double decimal) {
		return lt(BigDecimal.valueOf(decimal));
	}

	/**
	 * Checks whether input argument is <i><b> less than </b></i> to the provided
	 * {@link Long} or not;
	 *
	 * @param val value to compare
	 * @return {@link Boolean} value
	 */
	public boolean lt(long val) {
		return lt(BigDecimal.valueOf(val));
	}

	/**
	 * Checks whether input argument is <i><b> less than equal </b></i> to the provided
	 * {@link BigDecimal} or not. Null-safe: null is not lte any value.
	 *
	 * @param decimal value to compare
	 * @return {@link Boolean} value
	 */
	public boolean lte(BigDecimal decimal) {
		boolean result = (bigDecimal != null && decimal != null && bigDecimal.compareTo(decimal) <= ZERO);
		return negate ? !result : result;
	}

	/**
	 * Checks whether input argument is <i><b> less than equal </b></i> to the provided
	 * {@link Double} or not;
	 *
	 * @param decimal value to compare
	 * @return {@link Boolean} value
	 */
	public boolean lte(double decimal) {
		return lte(BigDecimal.valueOf(decimal));
	}

	/**
	 * Checks whether input argument is <i><b> less than equal </b></i> to the provided
	 * {@link Long} or not;
	 *
	 * @param val value to compare
	 * @return {@link Boolean} value
	 */
	public boolean lte(long val) {
		return lte(BigDecimal.valueOf(val));
	}

	// ---------- Long-form names (equivalent to eq, gt, gte, lt, lte) ----------

	/** Same as {@link #eq(BigDecimal)}. */
	public boolean equal(BigDecimal decimal) { return eq(decimal); }
	/** Same as {@link #eq(double)}. */
	public boolean equal(double decimal) { return eq(decimal); }
	/** Same as {@link #eq(long)}. */
	public boolean equal(long val) { return eq(val); }

	/** Same as {@link #gt(BigDecimal)}. */
	public boolean greaterThan(BigDecimal decimal) { return gt(decimal); }
	/** Same as {@link #gt(double)}. */
	public boolean greaterThan(double decimal) { return gt(decimal); }
	/** Same as {@link #gt(long)}. */
	public boolean greaterThan(long val) { return gt(val); }

	/** Same as {@link #gte(BigDecimal)}. */
	public boolean greaterThanOrEqual(BigDecimal decimal) { return gte(decimal); }
	/** Same as {@link #gte(double)}. */
	public boolean greaterThanOrEqual(double decimal) { return gte(decimal); }
	/** Same as {@link #gte(long)}. */
	public boolean greaterThanOrEqual(long val) { return gte(val); }

	/** Same as {@link #lt(BigDecimal)}. */
	public boolean lessThan(BigDecimal decimal) { return lt(decimal); }
	/** Same as {@link #lt(double)}. */
	public boolean lessThan(double decimal) { return lt(decimal); }
	/** Same as {@link #lt(long)}. */
	public boolean lessThan(long val) { return lt(val); }

	/** Same as {@link #lte(BigDecimal)}. */
	public boolean lessThanOrEqual(BigDecimal decimal) { return lte(decimal); }
	/** Same as {@link #lte(double)}. */
	public boolean lessThanOrEqual(double decimal) { return lte(decimal); }
	/** Same as {@link #lte(long)}. */
	public boolean lessThanOrEqual(long val) { return lte(val); }

	/**
	 * Returns true if the value is greater than zero. E.g. {@code is(x).positive()} or {@code is(x).not().positive()}.
	 *
	 * @return true if the value is greater than zero
	 */
	public boolean positive() {
		return gt(BigDecimal.ZERO);
	}

	/**
	 * Returns true if the value is less than zero. E.g. {@code is(x).negative()} or {@code is(x).not().negative()}.
	 *
	 * @return true if the value is less than zero
	 */
	public boolean negative() {
		return lt(BigDecimal.ZERO);
	}

	/**
	 * Returns true if the value is equal to zero. E.g. {@code is(x).zero()} or {@code is(x).not().zero()}.
	 *
	 * @return true if the value is equal to zero
	 */
	public boolean zero() {
		return eq(BigDecimal.ZERO);
	}

	/**
	 * Returns true if the value is null or zero. E.g. {@code is(x).nullOrZero()} or {@code is(x).not().nullOrZero()}.
	 *
	 * @return true if the value is null or zero
	 */
	public boolean nullOrZero() {
		// Compute raw "null or zero" without using zero(), so negate is applied only once
		boolean rawNullOrZero = (bigDecimal == null || (bigDecimal.compareTo(BigDecimal.ZERO) == ZERO));
		return negate ? !rawNullOrZero : rawNullOrZero;
	}

	public BigDecimal getBigDecimal() {
		return bigDecimal;
	}
}
