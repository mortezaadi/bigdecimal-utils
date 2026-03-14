package io.github.mortezaadi.bigdecimalutils;

import static org.junit.Assert.*;
import static io.github.mortezaadi.bigdecimalutils.BigDecimalUtils.*;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalUtilsTest {

	private BigDecimal one = new BigDecimal("1.4201");
	private BigDecimal two = new BigDecimal("3.521");
	private BigDecimal three = new BigDecimal("6.521");
	private BigDecimal four = new BigDecimal("6.521");

	@Test
	public void testTwoBigdecimalsEquality() {
		assertTrue(is(three).eq(four));
		assertTrue(is(one).eq(one));
		assertFalse(is(one).eq(two));
		assertTrue(is(three).eq(6.521));
		assertTrue(is(1).eq(1));
	}
	
	@Test
	public void testABigdecimalIsGratherThanTheOther() {
		assertFalse(is(three).gt(four));
		assertFalse(is(two).gt(two));
		assertTrue(is(two).gt(one));
		assertTrue(is(three).gt(two));
	}

	@Test
	public void testABigdecimalIsGratherThanEqualsToTheOther() {
		assertTrue(is(three).gte(four));
		assertTrue(is(two).gte(two));
		assertTrue(is(two).gte(one));
		assertFalse(is(two).gte(three));
	}

	@Test
	public void testABigdecimalIsLessThanTheOther() {
		assertFalse(is(three).lt(four));
		assertFalse(is(two).lt(two));
		assertTrue(is(one).lt(two));
		assertTrue(is(two).lt(three));
	}
	
	@Test
	public void testABigdecimalIsLessThanEqualsToTheOther() {
		assertTrue(is(three).lte(four));
		assertTrue(is(two).lte(two));
		assertTrue(is(one).lte(two));
		assertFalse(is(three).lte(two));
	}
	
	@Test
	public void testOneAndTwoAreNotEqual() {
		assertTrue(is(1).not().eq(2.1));
		assertTrue(is(one).not().eq(two));
	}
	
	@Test
	public void testOneInNotGreaterThanTwo() {
		assertTrue(is(1).not().gt(2));
		assertTrue(is(one).not().gt(two));
		assertTrue(is(one).not().gt(one));
	}
	@Test
	public void testOneInNotGreaterThanOrEqualWithTwo() {
		assertTrue(is(1).not().gte(2));
		assertTrue(is(one).not().gte(two));
		assertFalse(is(one).not().gte(one));
	}
	
	@Test
	public void testTwoInNotLessThanOne() {
		assertTrue(is(2.1).not().lt(1));
		assertTrue(is(two).not().lt(one));
		assertTrue(is(two).not().lt(two));
	}
	
	@Test
	public void testTwoInNotLessThanOrOne() {
		assertTrue(is(2).not().lte(1));
		assertTrue(is(two).not().lte(one));
		assertFalse(is(two).not().lte(two));
	}
	
	@Test
	public void testOneIsPositive() {
		assertTrue(is(1).positive());
	}
	
	@Test
	public void testZeroIsNonPositiveAndNonNegative() {
		assertTrue(is(0).not().positive() && is(0).not().negative());
	}
	
	@Test
	public void testMinusOneIsNegetive() {
		assertTrue(is(-1).negative());
	}
	
	@Test
	public void testMinusOneIsNotZero() {
		assertTrue(is(-1).not().zero());
	}
	
	@Test
	public void testZeroIsZero() {
		assertTrue(is(0).zero());
	}

	@Test
	public void testNullOrZero() {
		assertTrue(is(null).nullOrZero());
		assertTrue(is(0).nullOrZero());
		assertFalse(is(1).nullOrZero());
	}
	
	@Test
	public void testNotNullOrZero() {
		assertFalse(is(null).not().nullOrZero());
		assertFalse(is(0).not().nullOrZero());
		assertTrue(is(1).not().nullOrZero());
	}

	@Test
	public void testNullSafeEquality() {
		assertTrue(is((BigDecimal) null).eq(null));
		assertFalse(is((BigDecimal) null).eq(one));
		assertFalse(is(one).eq(null));
		assertTrue(is(one).eq(one));
	}

	@Test
	public void testNullSafeComparisons() {
		assertFalse(is((BigDecimal) null).gt(one));
		assertFalse(is(one).gt(null));
		assertFalse(is((BigDecimal) null).gte(one));
		assertFalse(is((BigDecimal) null).lt(one));
		assertFalse(is((BigDecimal) null).lte(one));
	}

	@Test
	public void testIsNotZero() {
		assertTrue(is(1).not().zero());
		assertFalse(is(0).not().zero());
	}

	@Test
	public void testFluentNotLte() {
		// is(x).not().lte(y) <=> !(x <= y) <=> x > y
		assertTrue(is(3).not().lte(2));
		assertFalse(is(2).not().lte(3));
		assertFalse(is(2).not().lte(2));
		assertTrue(is(two).not().lte(one));
		assertFalse(is(one).not().lte(two));
	}

	@Test
	public void testFluentNotEq() {
		assertTrue(is(1).not().eq(2));
		assertFalse(is(1).not().eq(1));
		assertTrue(is(one).not().eq(two));
	}

	@Test
	public void testFluentNotGt() {
		assertFalse(is(3).not().gt(2));
		assertTrue(is(1).not().gt(2));
	}

	@Test
	public void testFluentNotLt() {
		assertTrue(is(3).not().lt(2));
		assertFalse(is(1).not().lt(2));
	}

	@Test
	public void testFluentNotGte() {
		assertFalse(is(3).not().gte(2));
		assertTrue(is(1).not().gte(2));
		assertFalse(is(2).not().gte(2));
	}

	@Test
	public void testNotDoubleNegation() {
		// .not().not() is identity
		assertTrue(is(2).not().not().lte(3));
		assertTrue(is(2).lte(3));
		assertFalse(is(2).not().not().gt(3));
	}
}
