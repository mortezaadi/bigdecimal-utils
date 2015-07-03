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
	public void testTwoEqualBigdecimalsAreEqual() {
		assertTrue(is(three).eq(four));
		assertTrue(is(one).eq(one));
		assertTrue(!is(one).eq(two));
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
	
}
