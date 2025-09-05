package numberrangesummerizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

/*
* Assumptions:
* The input string is a comma-delimited list of integers.       [X]
* The input string is non-empty.                                [X]
* The input sequence of integers is sorted in ascending order.  [X]
* The input string does not contain any non-integer characters. [X]
* The input string does not contain any duplicate integers.     [X]
* The input string does not contain any integers less than 1.   [X]
* */

public class NumberRangeSummerizer implements NumberRangeSummerizerInterface {

    public Collection<Integer> collect(String input) {
        // Sanitizes input string with some error handling.
        String[] numbers = input.split(",");

        // TreeSets are ordered and sorted collections.
        Collection<Integer> outColection = new TreeSet<>();

        // iterate over the input string and add each number to the output collection.
        for (String num : numbers) {
            try {

                if (num.isBlank()) {
                    continue;
                }

                outColection.add(Integer.parseInt(num.strip()));

            } catch (NumberFormatException e) {

                System.out.println("NumberFormatException: %s" + e + "\nERROR: " + e.getMessage());
                throw e;

            }
        }

        return outColection;
    }

    public String summarizeCollection(Collection<Integer> input) {
        // this where the magic happens...

        input = new TreeSet<>(input); // enusre the input collection is sorted and has no duplicates.

        // early termination if the input collection is empty.
        if (input.isEmpty()) {
            return "";
        }

        ArrayList<String> numberStrings = new ArrayList<>();

        Iterator<Integer> iter = input.iterator();
        Integer prevNum = iter.next();
        Integer rangeNum = prevNum;

        while (iter.hasNext()) {
            Integer currNum = iter.next();

            if (currNum != prevNum + 1) {
                // Numbers are not consecutive
                if (rangeNum.equals(prevNum)) {
                    numberStrings.add(String.valueOf(prevNum));
                } else {
                    numberStrings.add(rangeNum + "-" + prevNum);
                }
                rangeNum = currNum;
            }

            prevNum = currNum;

        }

        // Add the final number or range
        if (rangeNum.equals(prevNum)) {
            numberStrings.add(String.valueOf(prevNum));
        } else {
            numberStrings.add(rangeNum + "-" + prevNum);
        }

        return String.join(", ", numberStrings);
    }


}
