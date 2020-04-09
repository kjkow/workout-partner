package com.github.kjkow.workoutpartner.session;

import com.github.kjkow.workoutpartner.commons.Events;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.noInteractions;

class StartedWorkoutTest {

    private final Events events = mock(Events.class);

    private StartedWorkout workout;
    private String exercise;

    @DisplayName("given started workout, should start exercise")
    @Test
    void testStartExercise() {
        //given
        startedWorkout();
        //and
        startingExerciseOnTheList();

        //when
        workout.startExercise(exercise);

        //then
        verify(events, times(1)).publish(any(ExerciseStarted.class));
    }

    @DisplayName("given started workout, " +
            "when starting exercise that is not on the plan, " +
            "should reject adding exercise")
    @Test
    void testStartExerciseNotOnPlan() {
        //given
        startedWorkout();
        //and
        startingExerciseNotOnPlan();

        //when
        workout.startExercise(exercise);

        //then
        verify(events, noInteractions()).publish(any()); //TODO sth else than no interactions? Rejected event?
    }

    private void startingExerciseNotOnPlan() {
        exercise = "bench press";
    }

    private void startingExerciseOnTheList() {
        exercise = "deadlift";
    }

    private void startedWorkout() {
        workout = new StartedWorkout(UUID.randomUUID(), events);
    }

}