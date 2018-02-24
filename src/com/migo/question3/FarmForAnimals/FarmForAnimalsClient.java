package com.migo.question3.FarmForAnimals;

/**
 * @author tausifakram
 *
 * FarmForAnimalsClient is the driver class for question 3
 */
public class FarmForAnimalsClient {

    private CountAnimalFarmHelper countAnimalFarmHelper;

    private static FarmForAnimalsClient farmForAnimalsClient;

    public FarmForAnimalsClient() {

	// Early binding of CountAnimalFarmHelper
	// the object will be binded at compile time
	countAnimalFarmHelper = new CountAnimalFarmHelper();

    }

    public static void main(String[] args) {

	// object created for the FarmForAnimalsClient
	// this will be used to call other methods
	// it will also initialize the object of CountAnimalFarmHelper
	farmForAnimalsClient = new FarmForAnimalsClient();

	String[] farm = new String[3];
	farm[0] = "YYYNYNY";
	farm[1] = "NNNYNYN";
	farm[2] = "YYYNYNY";

	System.out.println(farmForAnimalsClient.findUniqueArrangementOfFields(farm));

    }

    /**
     * @param farm
     * @return
     * findUniqueArrangementOfFields finds the uniue combination of fields
     * for cows and sheep
     */
    private int findUniqueArrangementOfFields(String[] farm) {

	int noOfFields;

	noOfFields = getNoOfFields(farm);
	System.out.println("noOfFields: " + noOfFields);
	return countAnimalFarmHelper.getCombinations(noOfFields);

    }

    /**
     * @param grid
     * @return
     * getNoOfFields finds unique fields in the farm
     */
    private int getNoOfFields(String[] grid) {

	int ROW = grid.length;
	int COL = grid[0].length();
	String[][] gridCell = new String[ROW][COL];

	for (int i = 0; i < ROW; i++) {
	    for (int j = 0; j < COL; j++) {

		gridCell[i][j] = grid[i].split("")[j];
	    }
	}
	
	// implementation of findNumberOfFields method of countAnimalFarmHelper is abstracted
	// OOPS Abstraction feature about hiding the complexity of the method and exposing
	// workable interface.

	return countAnimalFarmHelper.findNumberOfFields(gridCell, ROW, COL);
    }

}
