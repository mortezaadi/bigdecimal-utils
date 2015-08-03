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
Well, First of all you should know that if you use **equal** method of BigDecimal to compare two objects they only considered equal if they are equal in value and scale thus 2.0 is not equal to 2.00 when compared by
**equal** method. refer to JavaDocs.

To compare BigDecimal without considering their scale we should use **compareTo** method. So, probably this is 
the most common way to compare two BigDecimals. However it is so error prone and lacks readability.
to feel what it looks like take a look at this line of code :

    if(balance.compareTo(amount) < 0) && amount.compareTo(minAmount) >= 0)) {
      // ....
    }else {
      // ...
    }

the code above try to check condition "balance < amount && amount >= minAmount". You
definitely spotted the problem. But how to solve this?

How I Solve the Problem?
------------------------
BigDecimalUtils is a simple library to make comparing BigDecimal more readable and less error prone.
see the same comparison rewritten with this library

	import static ir.cafebabe.math.utils.BigDecimalUtils.*;
	..
	..
	..
	..
    if( is(balance).lt(amount) && is(amount).gte(minAmount) ) {
      // ....
    }else {
      // ...
    }

**Other methods in this library:**

      is(bigdecimal).eq(four); //Equal
      is(bigdecimal).gt(two);    //Greater than
      is(bigdecimal).gte(one);   //Greater than equal
      is(bigdecimal).lt(two);  //Less than
      is(bigdecimal).lte(two); //Less than equal
 
      is(bigdecimal).notEq(four); //Not Equal
      is(bigdecimal).notGt(two);    //Not Greater than
      is(bigdecimal).notGte(one);   //Not Greater than equal
      is(bigdecimal).notLt(two);  //Not Less than
      is(bigdecimal).notLte(two); //Not Less than equal
 
      is(bigdecimal).isZero(); 	
      is(bigdecimal).notZero(); 
      is(bigdecimal).isPositive(); // greater than zero
      is(bigdecimal).isNegetive(); // less than zero
      is(bigdecimal).isNonPositive(); //less than or equal zero
      is(bigdecimal).isNonNegetive(); //greater than or equal zero

      is(bigdecimal).isNullOrZero(); //is null or zero
      is(bigdecimal).notNullOrZero(); //not null or zero

PS
--------------------------
I didn't find any library to handle BigDecimal comparison. If you found one please let me know.



