package com.github.kjkow.workoutpartner.session;

import com.github.kjkow.workoutpartner.commons.Events;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class StartedWorkoutTest {

    private final Events events = mock(Events.class);

    private StartedWorkout startedWorkout;
    private String exercise;

    @DisplayName("given started workout, should start exercise")
    @Test
    void testStartExercise() {
        //given
        startedWorkout();
        //and
        startingExerciseOnTheList();

        //when
        var result = startedWorkout.startExercise(exercise);

        //then
        verify(events, times(1)).publish(any(ExerciseStarted.class));
        //and
        assertThat(result.isSuccess()).isTrue();
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
        var result = startedWorkout.startExercise(exercise);

        //then
        assertThat(result.isFailure()).isTrue();
        //and
        assertThat(result.getReason()).isNotEmpty();
    }

    private void startingExerciseNotOnPlan() {
        exercise = "bench press";
    }

    private void startingExerciseOnTheList() {
        exercise = "deadlift";
    }

    private void startedWorkout() {
        var exercises = List.of("deadlift");
        startedWorkout = new StartedWorkout(UUID.randomUUID(), events, exercises);
    }

}