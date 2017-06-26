[![](https://jitpack.io/v/mortezaadi/bigdecimal-utils.svg)](https://jitpack.io/#mortezaadi/bigdecimal-utils)

BigDecimal Utils
===============================================
Comparing BigDecimal is always hard to read and so error prone. I wrote this library
to make comparison of BigDecimal more comfortable and more readable. 

Is BigDecimal Comparison happens?
---------------------------------
Sure! The only reliable way to work with monetary amount is to use BigDecimal. So if you have 
Money somewhere in your code, you probably faced comparing two BigDecimals a lot.

What's wrong with BigDecimal comparison
--------------------------------------
Well, first of all you should know that if you use **equal** method of BigDecimal to compare two objects they only considered equal if they are equal in value and scale thus 2.0 is not equal to 2.00 when compared by
**equal** method refer to JavaDocs.

To compare BigDecimal without considering their scale we should use **compareTo** method. So, probably this is 
the most common way to compare two BigDecimals. However it is so error prone and lacks readability.
to feel what it looks like take a look at this line of code :

    return balance.compareTo(amount) < 0) && amount.compareTo(minAmount) >= 0));

the code above try to check condition "balance < amount && amount >= minAmount". You
definitely spotted the problem. But how to solve this?

How I Solve the Problem?
------------------------
BigDecimalUtils is a simple library to make comparing BigDecimal more readable and less error prone.
see the same comparison rewritten with this library

	import static ir.cafebabe.math.utils.BigDecimalUtils.*;

    // ...

    return is(balance).lt(amount) && is(amount).gte(minAmount));

**Other methods in this library:**

      is(bigdecimal).eq(four); // equal
      is(bigdecimal).gt(two); // greater than
      is(bigdecimal).gte(one); // greater than equal
      is(bigdecimal).lt(two); // less than
      is(bigdecimal).lte(two); // less than equal
 
      is(bigdecimal).notEq(four); // not equal
      is(bigdecimal).notGt(two); // not greater than
      is(bigdecimal).notGte(one); // not greater than equal
      is(bigdecimal).notLt(two); // not less than
      is(bigdecimal).notLte(two); // not less than equal
 
      is(bigdecimal).isZero(); 	
      is(bigdecimal).notZero(); 
      is(bigdecimal).isPositive(); // greater than zero
      is(bigdecimal).isNegetive(); // less than zero
      is(bigdecimal).isNonPositive(); // less than or equal zero
      is(bigdecimal).isNonNegetive(); // greater than or equal zero

      is(bigdecimal).isNullOrZero(); // is null or zero
      is(bigdecimal).notNullOrZero(); // not null or zero

You can also compare a BigDecimal to other numerical values. For instance instead of writing

      is(bigdecimal).notEq(BigDecimal.valueOf(4));

you can simply and interchangeably write:

      is(bigdecimal).notEq(4);
      is(bigdecimal).notEq(4L);
      is(bigdecimal).notEq(4D);
       
Why BigDecimal Utils?
--------------------------
I didn't find any library to handle BigDecimal comparison. If you found one please let me know.



