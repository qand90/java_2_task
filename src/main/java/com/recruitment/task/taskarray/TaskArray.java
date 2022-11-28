package com.recruitment.task.taskarray;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskArray {

    public static boolean containTheRightSum(final Integer[] array) {
        return Arrays.stream(array)
                .anyMatch(number -> {
                    final Integer numberIncremented = number + 1; //2 (first iteration)
                    final List<Integer> newArrayOfIntegers = Arrays.stream(array)  // {1,3,7,3,5}
                            .filter(numberFromNewArray -> !Objects.equals(numberFromNewArray, number)) // it will remove duplicated number
                            .collect(Collectors.toList()); //  {3,7,3,5}
                    final Set<Integer> givenSumSet = newArrayOfIntegers
                            .stream()
                            .flatMap(currentNumber -> { // due to avoid list of list (first iteration current number = 3 etc..)
                                return newArrayOfIntegers.stream() //{3,7,3,5}
                                        .filter(numberFromNewArray -> !Objects.equals(numberFromNewArray, currentNumber)) // it will remove duplicated number, after this filter {7,3,5}, for first iteration.
                                        .map(numberFromNewArray -> currentNumber + numberFromNewArray); //first iteration  10 (3+7), 6 (3+3), 8 (3+5) || second iteration 10 (7+3), 10 (7+3), 12 (7+5) etc..
                            })
                            .collect(Collectors.toSet()); //to set to avoid duplication
                    return givenSumSet.contains(numberIncremented);
                });
    }
}
