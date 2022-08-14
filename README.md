# Cart-AdditionalUnitTestTopics: JUnit annotations
 
## Exercise: Additional Unit Test Topics

This is an exercise about JUnit. `Cart-AdditionalUnitTestTopics` folder contains a maven project. This project contains a class extending 
a previous calculator (using decorator pattern) to include credits and specials discounts for different types of 
users. The goal is to use more **JUnit** annotations like `@BeforeAll`, `@BeforeAll`, `@RepeatedTest(n)`, `@ParameterizedTest`, `@MethodSource`


## Test `TotalsWithDiscountCalculator`

There is some code on the `TotalsWithDiscountCalculatorTest`.
Here is what we did:

1. The method `getTotalsWithDiscounts_regularAndPlatinumUser_returnsDifferentSubtotal` receives
an `User` as parameter, we added the required annotations to get different types of users, and a different
expected result. Tip: The method `differentUserTypesAndExpectedTotals` provide those.

2. `getTotalsWithDiscounts_userWithCredit_chargedMultipleTimes` test that a user can be charged multiple times.
    1. We added the required annotation to initialize the `globalUser` in the `setupGlobalUser` method.
    2. The same user can be used by different calculators, we added the required annotation to initialize them in 
    `setupCalculator` method.
    3. We made the `getTotalsWithDiscounts_userWithCredit_chargedMultipleTimes` method repeat three times. 

 