package com.migo.question1.evenOddString;

/**
 * @author tausifakram
 *	EvenOddBean represents getter for fields.
 *	This class encapsulate the data with method.
 */
public class EvenOddBean {

    // members being private and final.
    // Hence the value will be not changed and the 
    // members will be not directly accessible to other class.
    // Accessibility is given by getter methods.
    private final String even = "EVEN";
    private final String odd = "ODD";

    public String getEven() {
	return even;
    }

    public String getOdd() {
	return odd;
    }

}
