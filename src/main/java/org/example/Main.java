package org.example;

import numberrangesummerizer.NumberRangeSummerizer;

import java.util.Collection;


final class Main {

    private Main() {

    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Here is an example usage of the %s class:%n%n", "NumberRangeSummerizer");

        NumberRangeSummerizer summerizerObj = new NumberRangeSummerizer();

        String input = "1, 2, 3, 4, 7, 8, 9, 10";

        Collection<Integer> outCol = summerizerObj.collect(input);
        String outStr = summerizerObj.summarizeCollection(outCol);
//
        System.out.printf(
                "The summary of the list of numbers: %s\nis: %s.\n",
                input,
                outStr
        );

    }
}