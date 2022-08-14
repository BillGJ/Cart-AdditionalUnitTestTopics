package com.udacity.cart.service;

import com.udacity.cart.model.CartItem;
import com.udacity.cart.model.CartTotals;
import com.udacity.cart.model.User;
import com.udacity.cart.model.UserType;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TotalsWithDiscountCalculatorTest {

	static private User globalUSer;
	private TotalsWithDiscountCalculator totalsWithDiscountCalculator;

	@BeforeAll
	static void setupGlobalUser(){
		System.out.println("Setting up user");
		globalUSer = new User("UserPerson", UserType.REGULAR, 100.00);
	}

	// Replace this with a Repeated test. Use a BeforeAll method to create a user whose credit
	// will be reduced with each repetition, and use a BeforeEach method to create a new TotalsWithDiscountCalculator
	// for each repetition.

	@BeforeEach
	void setupCalculator(){
		System.out.println("Setting up Calculator");
		totalsWithDiscountCalculator = new TotalsWithDiscountCalculator(globalUSer);
	}

	@RepeatedTest(3)
	public void totalsWithDiscount_getTotals_reducesUserCredit(RepetitionInfo repetitionInfo) {

		totalsWithDiscountCalculator.getTotals(List.of(new CartItem("Twenty dollar item", 20.0, 0)));
		assertEquals(100.0 - (repetitionInfo.getCurrentRepetition() * 20), globalUSer.getCredit());
	}

	// Replace this with a parameterized test that uses a MethodSource to provide
	// a stream of arguments allowing you to test both regular and platinum users with the
	// same test.
	@ParameterizedTest
	@MethodSource("differentUserTypesAndExpectedTotals")
	public void totalsWithDiscounts_regularAndPlatinumUser_returnsDifferentSubtotal(User user, CartTotals expectedCartTotals) {

		TotalsWithDiscountCalculator totalsWithDiscountCalculator = new TotalsWithDiscountCalculator(user);

		CartTotals cartTotals = totalsWithDiscountCalculator.getTotals(
				List.of(new CartItem("Ten dollars item", 10.0, 1.0)));

		assertEquals(expectedCartTotals, cartTotals);

	}

	private static Stream<Arguments> differentUserTypesAndExpectedTotals(){
		return Stream.of(
				Arguments.of(new User("Regular User", UserType.REGULAR, 0.0),
						new CartTotals(10.00, 1.00)),
				Arguments.of(new User("Platinum User", UserType.PLATINUM, 0.0),
						new CartTotals(9.00, 1.00))
		);
	}
}