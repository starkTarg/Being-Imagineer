package com.migo.question3.FarmForAnimals;

import java.math.BigInteger;

/**
 * @author tausifakram 
 * 	   CountAnimalFarmHelper represents multiple inheritance
 *         with interfaces. CountAnimalFarmHelper inherits methods necessary to
 *         find farms for sheeps and cows
 */
public final class CountAnimalFarmHelper implements CombinationHelperInterface, FarmFinderInterface {


    // final, static initialization. These will be class
    // members and will be shared between objects of this
    
    private static final BigInteger moduloFactor = BigInteger.valueOf(1000000007L);
    private final static String Y = "Y";
    private final static int[] neighbourAddress = { -1, 0, 1 };

    /* (non-Javadoc)
     * @see com.migo.question2.FarmForAnimals.FarmFinderInterface#findNumberOfFields(java.lang.String[][], int, int)
     * This method finds number of unique fields.
     */
    @Override
    public int findNumberOfFields(String[][] gridCell, int ROW, int COL) {

	boolean[][] visited = new boolean[ROW][COL];
	int fieldCount = 0;

	for (int i = 0; i < ROW; i++) {
	    for (int j = 0; j < COL; j++) {

		if (gridCell[i][j].equals(Y) && (!visited[i][j])) {
		    fieldCount++;
		    findAdjacentFileds(gridCell, i, j, visited);
		}
	    }
	}
	return fieldCount;

    }

    /* (non-Javadoc)
     * @see com.migo.question2.FarmForAnimals.FarmFinderInterface#findAdjacentFileds(java.lang.String[][], int, int, boolean[][])
     * This method find connected fields.
     */
    @Override
    public void findAdjacentFileds(String[][] gridCell, int i, int j, boolean[][] visited) {

	if (visited[i][j]) {
	    return;
	}

	visited[i][j] = true;
	int neighbourAddressX, neighbourAddressY;
	for (int x = 0; x < neighbourAddress.length; x++) {

	    neighbourAddressX = neighbourAddress[x];

	    for (int y = 0; y < neighbourAddress.length; y++) {

		neighbourAddressY = neighbourAddress[y];

		if ((neighbourAddressX == 0 && neighbourAddressY == 0)
			|| (Math.abs(neighbourAddressX) == 1 && Math.abs(neighbourAddressY) == 1))
		    continue;
		if (isAdjacentFieldExists(gridCell, i + neighbourAddressX, j + neighbourAddressY)) {

		    findAdjacentFileds(gridCell, i + neighbourAddressX, j + neighbourAddressY, visited);

		}
	    }

	}

    }

    private static boolean isAdjacentFieldExists(String[][] gridCell, int i, int j) {

	if ((i >= 0) && (i < gridCell.length) && (j >= 0) && (j < gridCell[0].length)) {

	    if (gridCell[i][j].equals(Y))
		return true;
	}

	return false;
    }

    /* (non-Javadoc)
     * @see com.migo.question2.FarmForAnimals.CombinationHelperInterface#getFactorial(int)
     * This method calculates factorial of the input number.
     */
    @Override
    public BigInteger getFactorial(int number) {

	BigInteger fact = BigInteger.ONE;

	for (int i = 2; i <= number; i++) {
	    fact = fact.multiply(new BigInteger(String.valueOf(i)));
	}

	return fact;

    }

    /* (non-Javadoc)
     * @see com.migo.question2.FarmForAnimals.CombinationHelperInterface#getCombinations(int)
     * Calculates combination for the found unique number of the fields.
     */
    @Override
    public int getCombinations(int uniqueFields) {

	BigInteger totalCombinations = BigInteger.ZERO;
	BigInteger result = BigInteger.ZERO;
	if (uniqueFields == 1 || uniqueFields == 0) {
	    return 1;
	}

	int combinationFactor = 2;
	BigInteger nominatorFact = BigInteger.ZERO;

	while (combinationFactor < uniqueFields) {

	    if (nominatorFact.equals(BigInteger.ZERO))
		nominatorFact = getFactorial(uniqueFields);

	    result = nominatorFact
		    .divide(getFactorial(uniqueFields - combinationFactor).multiply(getFactorial(combinationFactor)));
	    totalCombinations = totalCombinations.add(result);
	    combinationFactor = combinationFactor + 2;
	}
	if (uniqueFields % 2 == 0)
	    return (totalCombinations.add(BigInteger.valueOf(2L)).mod(moduloFactor)).intValue();
	return (totalCombinations.add(BigInteger.valueOf(1L)).mod(moduloFactor)).intValue();

    }

}
