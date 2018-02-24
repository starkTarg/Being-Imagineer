package com.migo.question3.FarmForAnimals;

public interface FarmFinderInterface {
    
    int findNumberOfFields(String[][] gridCell, int ROW, int COL);
    
    void findAdjacentFileds(String[][] gridCell, int i, int j, boolean[][] visited);

}
