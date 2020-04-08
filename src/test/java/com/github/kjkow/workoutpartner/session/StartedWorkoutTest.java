package com.github.kjkow.workoutpartner.session;

import com.github.kjkow.workoutpartner.commons.Events;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.mockito.Mockito.*;

class StartedWorkoutTest {

    private final Events events = mock(Events.class);

    @DisplayName("") //todo description
    @Test
    void testStartExercise() {
        //given
        var startedWorkout = new StartedWorkout(UUID.randomUUID(), events);
        var deadLiftExercise = "deadlift";

        //when
        startedWorkout.startExercise(deadLiftExercise);

        //then
        verify(events, times(1)).publish(any(ExerciseStarted.class));
    }

}