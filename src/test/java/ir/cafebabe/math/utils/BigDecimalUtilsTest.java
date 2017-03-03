package ir.cafebabe.math.utils;

import static org.junit.Assert.*;

import static ir.cafebabe.math.utils.BigDecimalUtils.*;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalUtilsTest {

	BigDecimal one = new BigDecimal("1.4201");
	BigDecimal two = new BigDecimal("3.521");
	BigDecimal three = new BigDecimal("6.521");
	BigDecimal four = new BigDecimal("6.521");

	@Test
	public void testTwoBigdecimalsEquality() {
		assertTrue(is(three).eq(four));
		assertTrue(is(one).eq(one));
		assertTrue(!is(one).eq(two));
		assertTrue(is(three).eq(6.521));
		assertTrue(is(1).eq(1));
	}
	
	@Test
	public void testABigdecimalIsGratherThanTheOther() {
		assertTrue(!is(three).gt(four));
		assertTrue(!is(two).gt(two));
		assertTrue(is(two).gt(one));
		assertTrue(is(three).gt(two));
	}

	@Test
	public void testABigdecimalIsGratherThanEqualsToTheOther() {
		assertTrue(is(three).gte(four));
		assertTrue(is(two).gte(two));
		assertTrue(is(two).gte(one));
		assertTrue(!is(two).gte(three));
	}

	@Test
	public void testABigdecimalIsLessThanTheOther() {
		assertTrue(!is(three).lt(four));
		assertTrue(!is(two).lt(two));
		assertTrue(is(one).lt(two));
		assertTrue(is(two).lt(three));
	}
	
	@Test
	public void testABigdecimalIsLessThanEqualsToTheOther() {
		assertTrue(is(three).lte(four));
		assertTrue(is(two).lte(two));
		assertTrue(is(one).lte(two));
		assertTrue(!is(three).lte(two));
	}
	
	@Test
	public void testOneAndTwoAreNotEqual() {
		assertTrue(is(1).notEq(2));
		assertTrue(is(one).notEq(two));
	}
	
	@Test
	public void testOneInNotGreaterThanTwo() {
		assertTrue(is(1).notGt(2));
		assertTrue(is(one).notGt(two));
		assertTrue(is(one).notGt(one));
	}
	@Test
	public void testOneInNotGreaterThanOrEqualWithTwo() {
		assertTrue(is(1).notGte(2));
		assertTrue(is(one).notGte(two));
		assertFalse(is(one).notGte(one));
	}
	
	@Test
	public void testTwoInNotLessThanOne() {
		assertTrue(is(2).notLt(1));
		assertTrue(is(two).notLt(one));
		assertTrue(is(two).notLt(two));
	}
	
	@Test
	public void testTwoInNotLessThanOrOne() {
		assertTrue(is(2).notLte(1));
		assertTrue(is(two).notLte(one));
		assertFalse(is(two).notLte(two));
	}
	
	@Test
	public void testOneIsPositive() {
		assertTrue(is(1).isPositive());
	}
	
	@Test
	public void testZeroIsNonPositiveAndNonNegetive() {
		assertTrue(is(0).isNonPositive() && is(0).isNonNegative());
	}
	
	@Test
	public void testMinusOneIsNegetive() {
		assertTrue(is(-1).isNegative());
	}
	
	@Test
	public void testMinusOneIsNotZero() {
		assertTrue(is(-1).isNotZero());
	}
	
	@Test
	public void testZeroIsZero() {
		assertTrue(is(0).isZero());
	}

	@Test
	public void testNullOrZero() {
		assertTrue(is(null).isNullOrZero());
		assertTrue(is(0).isNullOrZero());
		assertFalse(is(1).isNullOrZero());
	}
	
	@Test
	public void testNotNullOrZero() {
		assertFalse(is(null).notNullOrZero());
		assertFalse(is(0).notNullOrZero());
		assertTrue(is(1).notNullOrZero());
	}
	
	
	
}

