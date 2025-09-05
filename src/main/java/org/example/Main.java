package org.example;

import numberrangesummerizer.NumberRangeSummerizer;

import java.util.Collection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Here is an example usage of the %s class:%n%n", "NumberRangeSummerizer");

        NumberRangeSummerizer summerizer_obj = new NumberRangeSummerizer();

        String input = "1, 2, 3, 4, 7, 8, 9, 10";

        Collection<Integer> out_col = summerizer_obj.collect(input);
        String out_str = summerizer_obj.summarizeCollection(out_col);
//
        System.out.printf(
                "The summary of the list of numbers: %s\nis: %s.\n",
                input,
                out_str
        );

    }
}