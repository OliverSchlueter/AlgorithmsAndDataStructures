package de.oliver.problems.leetcode;

public class GoalParserInterpretation {

    /*
        https://leetcode.com/problems/goal-parser-interpretation/
     */

    public String interpret(String command) {
        return command.replace("()", "o").replace("(", "").replace(")", "");
    }

}
