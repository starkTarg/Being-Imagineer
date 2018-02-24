package com.migo.question1.evenOddString;

import java.util.List;

public interface EvenOddHelperInterface {

    boolean isStringEven(String string);

    List<Object> keyboardInput() throws EventOddException;

    String processInputArray(String[] A);

}
