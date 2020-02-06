package com.github.kjkow.workoutpartner.session;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WorkoutTest {

    @DisplayName("given new workout session with any trainee, when beginning workout then workout is started ")
    @Test
    void oneCanBeginWorkout() {
        //given
        var session = new WorkoutSession(anyTrainee());

        //when
        session.beginWorkout();

        //then
        assertTrue(session.isStarted());
    }

    private Trainee anyTrainee() {
        return new Trainee();
    }
}
