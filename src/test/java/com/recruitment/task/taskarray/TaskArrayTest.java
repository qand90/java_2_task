package com.recruitment.task.taskarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskArrayTest {

    @Test
    public void shouldContainsTheMatch() {
        //given
        final Integer[] givenArray = {1, 3, 7, 3, 5};

        //when
        final boolean result = TaskArray.containTheRightSum(givenArray);

        //then
        assertTrue(result);
    }


    @Test
    public void shouldNotContainTheMatch() {

        final Integer[] givenArray = {1, 4, 10};

        //when
        final boolean result = TaskArray.containTheRightSum(givenArray);

        //then
        assertFalse(result);
    }

}