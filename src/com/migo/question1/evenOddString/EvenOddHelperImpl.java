package com.migo.question1.evenOddString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tausifakram
 * EvenOddHelperImpl provides helper method for Question 1
 * and inherits method from EvenOddHelperInterface.
 */
public class EvenOddHelperImpl implements EvenOddHelperInterface {

    private EvenOddBean evenOddBean;

    public EvenOddHelperImpl() {
	// Below instantiation of evenOddBean is lazy initialization
	// This helps to save resources and create object when needed.
	evenOddBean = new EvenOddBean();
    }

    @Override
    public List<Object> keyboardInput() throws EventOddException {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	List<Object> stringArrayList = new ArrayList<>();

	try {
	    // No. of TestCases
	    int noOfTests = Integer.parseInt(br.readLine());
	    long exponentarray[] = new long[noOfTests];
	    for (int i = 0; i < noOfTests; i++) {

		// M and K
		String lines = br.readLine();
		String[] strs = lines.trim().split("\\s+");
		exponentarray[i] = Long.parseLong(strs[0]);

		// string array
		String arrayInput = br.readLine();
		String[] stringArray = arrayInput.trim().split("\\s+");

		stringArrayList.add(stringArray);

	    }

	} catch (NumberFormatException | IOException e) {
	    throw new EventOddException("Error while taking input");
	}

	return stringArrayList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.migo.question1.evenOddString.EvenOddHelperInterface#isStringEven(java
     * .lang.String) This function does the ground work of calculating whether
     * one of the string in an array is even or odd. Mathematical assumptions
     * are made. ODD ^ ODD/EVEN is ODD EVEN ^ ODD/EVEN is EVEN
     */
    @Override
    public boolean isStringEven(String string) {

	// if there is even and odd character the string is even
	// if all char are even then string is even
	// if all char is odd then string is odd
	boolean hasEvenAndOdd = false;
	long oddCounter = 0;
	long evenCounter = 0;
	String[] stringArray = string.split("");
	for (String str : stringArray) {

	    // IntelligentASCIIMap.intelligentMap is being accessed directly
	    // without creating object of IntelligentASCIIMap. This shows
	    // intelligentMap belongs to class rather than object of the class.

	    if (IntelligentASCIIMap.intelligentMap.get(str) == 0) {
		evenCounter++;
	    }

	    if (IntelligentASCIIMap.intelligentMap.get(str) == 1) {
		oddCounter++;
	    }

	    if (evenCounter > 0 && oddCounter > 0) {
		hasEvenAndOdd = true;
		break;
	    }
	}

	// string alone is even
	if (hasEvenAndOdd || evenCounter == stringArray.length) {
	    // check if string to power M is even
	    // even to power even/odd is even
	    // odd to power odd/even is odd
	    return true;
	}

	return false;

    }

    /* (non-Javadoc)
     * @see com.migo.question1.evenOddString.EvenOddHelperInterface#processInputArray(java.lang.String[])
     * This function odes the summation part of array to evaluate
     * if array of strings as whole is even or odd
     */
    @Override
    public String processInputArray(String A[]) {

	int evenOddSumCounter = 0;

	for (int j = 0; j < A.length; j++) {

	    if (isStringEven(A[j])) {
		evenOddSumCounter += 0;
	    } else {
		evenOddSumCounter += 1;
	    }
	}

	if (evenOddSumCounter % 2 == 0) {
	    // Represents Encapsulation of OOPS methodology.
	    // Member of EvenOddBean is accessed by method
	    // provided by EvenOddBean. The members of EvenOddBean
	    // or hidden from EvenOddHelperImpl.
	    return evenOddBean.getEven();
	} else
	    return evenOddBean.getOdd();

    }

}
