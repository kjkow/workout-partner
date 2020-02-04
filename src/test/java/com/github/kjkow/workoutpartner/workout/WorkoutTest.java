package com.github.kjkow.workoutpartner.workout;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WorkoutTest {

    @Test
    void oneCanBeginWorkout() {
        //when
        var session = WorkoutSession.begin();

        //then
        assertThat(session.isStarted());
    }
}
