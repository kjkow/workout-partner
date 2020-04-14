package com.github.kjkow.workoutpartner.session;

import com.github.kjkow.workoutpartner.commons.Events;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class StartedExerciseTest {

    private final Events events = mock(Events.class);

    private StartedExercise startedExercise;

    @DisplayName("should start new set")
    @Test
    void testStartSet() {
        //given
        startedExercise();

        //when
        var result = startedExercise.startSet();

        //then
        assertThat(result.isSuccess());
    }

    private void startedExercise() {
        startedExercise = new StartedExercise(UUID.randomUUID(), events);
    }

}