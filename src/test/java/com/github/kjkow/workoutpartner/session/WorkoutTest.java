package com.github.kjkow.workoutpartner.session;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WorkoutTest {

    @DisplayName("given new workout session with any trainee, when beginning workout then workout is started ")
    @Test
    void oneCanBeginWorkout() {
        //given
        var session = new WorkoutSession(anyTrainee(), anyWorkoutPlan());

        //when
        session.beginWorkout();

        //then
        assertTrue(session.isStarted());
    }

    private WorkoutSessionPlan anyWorkoutPlan() {
        var repetition = new WorkoutRepetition(Weight.ofKilograms(350));
        var deadLiftSet = new WorkoutSet("deadLift", singletonList(repetition));
        return new WorkoutSessionPlan(anyTrainee(), singletonList(deadLiftSet));
    }

    private Trainee anyTrainee() {
        return new Trainee("Takeshi Kovacs");
    }
}
