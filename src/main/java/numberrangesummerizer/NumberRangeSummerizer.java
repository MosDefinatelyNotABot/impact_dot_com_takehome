package numberrangesummerizer;

import java.util.*;

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
        Collection<Integer> out_colection = new TreeSet<>();

        // iterate over the input string and add each number to the output collection.
        for (String num : numbers) {
            try {
                if (num.isBlank()) {continue;}

                out_colection.add(Integer.parseInt(num.strip()));
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException: %s" + e + "\nERROR: "+ e.getMessage());
                throw e;
            }
        }

        return out_colection;
    }

    public String summarizeCollection(Collection<Integer> input) {
        // this where the magic happens...

        input = new TreeSet<>(input); // enusre the input collection is sorted and has no duplicates.

        // early termination if the input collection is empty.
        if (input.isEmpty()) {
            return "";
        }

        ArrayList<String> number_strings = new ArrayList<>();

        Iterator<Integer> iter = input.iterator();
        Integer prev_num = iter.next();
        Integer range_start = prev_num;

        while (iter.hasNext()) {
            Integer current_num = iter.next();

            if (current_num != prev_num + 1) {
                // Numbers are not consecutive
                if (range_start.equals(prev_num)) {
                    number_strings.add(String.valueOf(prev_num));
                } else {
                    number_strings.add(range_start + "-" + prev_num);
                }
                range_start = current_num;
            }

            prev_num = current_num;

        }

        // Add the final number or range
        if (range_start.equals(prev_num)) {
            number_strings.add(String.valueOf(prev_num));
        } else {
            number_strings.add(range_start + "-" + prev_num);
        }

        return String.join(", ", number_strings);
    }


}
