[![Codacy Badge](https://api.codacy.com/project/badge/Grade/a4a8e13df7804fd6a4d5081580dc1469)](https://app.codacy.com/app/mortezaadi/bigdecimal-utils?utm_source=github.com&utm_medium=referral&utm_content=mortezaadi/bigdecimal-utils&utm_campaign=Badge_Grade_Dashboard)
[![](https://jitpack.io/v/mortezaadi/bigdecimal-utils.svg)](https://jitpack.io/#mortezaadi/bigdecimal-utils)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.mortezaadi/bigdecimal-utils.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.mortezaadi%22%20AND%20a:%22bigdecimal-utils%22)
[![CI](https://github.com/mortezaadi/bigdecimal-utils/actions/workflows/ci.yml/badge.svg)](https://github.com/mortezaadi/bigdecimal-utils/actions/workflows/ci.yml)
[![codecov](https://codecov.io/gh/mortezaadi/bigdecimal-utils/branch/master/graph/badge.svg)](https://codecov.io/gh/mortezaadi/bigdecimal-utils)

BigDecimal Utils
===============================================
Comparing BigDecimal is always hard to read and too error prone. I wrote this library
to make comparison of BigDecimal more comfortable and more readable. 

Maven:
```xml
    <dependency>
  	<groupId>io.github.mortezaadi</groupId>
  	<artifactId>bigdecimal-utils</artifactId>
  	<version>2.2.0</version>
    </dependency>
```

Gradle:

    implementation 'io.github.mortezaadi:bigdecimal-utils:2.1.0'

Gradle Kotlin DSL:

    implementation("io.github.mortezaadi:bigdecimal-utils:2.1.0")
    
Scala SBT:

    libraryDependencies += "io.github.mortezaadi" % "bigdecimal-utils" % "2.1.0"

Is BigDecimal Comparison happens
---------------------------------
Sure! The only reliable way to work with monetary amount is to use BigDecimal. So if you have 
Money somewhere in your code, you probably found yourself comparing two BigDecimals.

What's wrong with BigDecimal comparison
--------------------------------------
Well, As you should know, if you use **equal** method of BigDecimal to compare two objects, they only considered equal if they are equal in value and scale thus 2.0 is not equal to 2.00 when compared by
**equal** method (refer to JavaDocs).

To compare BigDecimal without considering their scale we should use **compareTo** method. This is 
the most common and correct way to compare two BigDecimals. However it is so error prone and lacks readability.
To feel what it looks like, take a look at this line of code :

    return balance.compareTo(amount) < 0) && amount.compareTo(anotherAmount) >= 0));

The above code tries to check the condition in which "balance < amount && amount >= anotherAmount". You
definitely spotted the issue here. The **compareTo** is not clear nor readable. 
But how to solve this?

How I Solve the Problem
------------------------
BigDecimalUtils is a simple library that enables us to compare BigDecimal objects in a more readable and less error-prone way.
see the same comparison rewritten by this library

	import static io.github.mortezaadi.bigdecimalutils.BigDecimalUtils.*;

    // ...

    return is(balance).lt(amount) && is(amount).gte(minAmount));

**Other methods in this library:**

  Comparisons (short and long names are equivalent):

      is(bigdecimal).eq(four);    // or .equal(four)     — equal
      is(bigdecimal).gt(two);    // or .greaterThan(two)
      is(bigdecimal).gte(one);   // or .greaterThanOrEqual(one)
      is(bigdecimal).lt(two);    // or .lessThan(two)
      is(bigdecimal).lte(two);   // or .lessThanOrEqual(two)
 
      is(bigdecimal).not().eq(four);   // or .not().equal(four)
      is(bigdecimal).not().gt(two);    // or .not().greaterThan(two)
      is(bigdecimal).not().gte(one);   // or .not().greaterThanOrEqual(one)
      is(bigdecimal).not().lt(two);    // or .not().lessThan(two)
      is(bigdecimal).not().lte(two);   // or .not().lessThanOrEqual(two)
 
      is(bigdecimal).zero();                     // "is x zero?"
      is(bigdecimal).not().zero();              // "is x not zero?"
      is(bigdecimal).positive();                // "is x positive?"
      is(bigdecimal).negative();                // "is x negative?"
      is(bigdecimal).not().positive();         // "is x not positive?" (<= 0)
      is(bigdecimal).not().negative();          // "is x not negative?" (>= 0)

      is(bigdecimal).nullOrZero();              // "is x null or zero?"
      is(bigdecimal).not().nullOrZero();        // "is x not (null or zero)?"

You can also compare a BigDecimal to other numerical values. For instance instead of writing

      is(bigdecimal).not().eq(BigDecimal.valueOf(4));

you can simply and interchangeably write:

      is(bigdecimal).not().eq(4);
      is(bigdecimal).not().eq(4L);
      is(bigdecimal).not().eq(4D);
       
Why BigDecimal Utils?
--------------------------
I didn't find any library to handle BigDecimal comparison. If you found one please let me know.



