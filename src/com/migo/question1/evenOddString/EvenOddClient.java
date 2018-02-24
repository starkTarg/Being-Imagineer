package com.migo.question1.evenOddString;

import java.util.List;

/**
 * @author tausifakram
 * EvenOddClient is the driver class of Question 1
 */
public class EvenOddClient {

    // Reference of EvenOddHelperInterface, an interface is declared
    private EvenOddHelperInterface evenOddHelper;

    // static member and can be used by static methods
    private static EvenOddClient evenOddClient;

    public EvenOddClient() {

	// Lazy initialization of evenOddHelper.
	// This also represents late binding since the object
	// type will be decided at the run time, a aspect of polymorphism
	evenOddHelper = new EvenOddHelperImpl();
    }

    public static void main(String[] args) {

	// creates object of EvenOddClient which instantiates the 
	// EvenOddHelperImpl object.
	evenOddClient = new EvenOddClient();

	try {

	    List<Object> stringInputArray = evenOddClient.evenOddHelper.keyboardInput();
	    evenOddClient.calculateEvenOddStrings(stringInputArray);

	} catch (EventOddException e) {

	    e.printStackTrace();
	} catch (Exception e) {

	    e.printStackTrace();
	}
    }

    /**
     * @param stringArrayList
     *            This function passes the list of test cases to 'processArray'
     *            to calculate whether the array A is odd or even
     */
    private void calculateEvenOddStrings(List<Object> stringArrayList) {

	for (int i = 0; i < stringArrayList.size(); i++) {

	    // processInputArray method of evenOddHelper is called.
	    // This represents abstraction since the evenOddClient does not know
	    // what goes in when the method is called.
	    String result = evenOddClient.evenOddHelper.processInputArray((String[]) stringArrayList.get(i));
	    System.out.println(result);

	}
    }

}
