package de.oliver.problems.aoc2022;

import java.io.IOException;
import java.io.InputStream;

public class InputHelper {

    public static String readInput(String fileName){
        try {
            InputStream in = InputHelper.class.getResourceAsStream("/aoc2022/" + fileName);
            return new String(in.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
