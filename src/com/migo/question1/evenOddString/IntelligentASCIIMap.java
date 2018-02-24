package com.migo.question1.evenOddString;

import java.util.HashMap;

public class IntelligentASCIIMap {

    // Intelligent map to handle 'calculations of ASCII'
    // Basically I categorized the alphabets as odd or even
    // A way of work around to the naive way of heavy multiplication
    
    // intelligentMap is protected to be accessible by other class in the package.
    // since this is relevant to question 1 and hence should not be accessed
    // by others.
    protected static final HashMap<String, Integer> intelligentMap;

    // Static block initializes when IntelligentASCIIMap loads.
    // Static member will be part of class and not class object.
    static {
	intelligentMap = new HashMap<>();

	intelligentMap.put("a", 1);
	intelligentMap.put("b", 0);
	intelligentMap.put("c", 1);
	intelligentMap.put("d", 0);
	intelligentMap.put("e", 1);
	intelligentMap.put("f", 0);
	intelligentMap.put("g", 1);
	intelligentMap.put("h", 0);
	intelligentMap.put("i", 1);
	intelligentMap.put("j", 0);
	intelligentMap.put("k", 1);
	intelligentMap.put("l", 0);
	intelligentMap.put("m", 1);
	intelligentMap.put("n", 0);
	intelligentMap.put("o", 1);
	intelligentMap.put("p", 0);
	intelligentMap.put("q", 1);
	intelligentMap.put("r", 0);
	intelligentMap.put("s", 1);
	intelligentMap.put("t", 0);
	intelligentMap.put("u", 1);
	intelligentMap.put("v", 0);
	intelligentMap.put("w", 1);
	intelligentMap.put("x", 0);
	intelligentMap.put("y", 1);
	intelligentMap.put("z", 0);
    }

}
