package com.github.kjkow.workoutpartner.session;

import com.github.kjkow.workoutpartner.commons.Events;
import com.github.kjkow.workoutpartner.planning.TraineeId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.github.kjkow.workoutpartner.planning.Fixture.anyWorkoutPlan;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class WorkoutSessionTest {

    private final Events events = mock(Events.class);

    @DisplayName("given new workout session and any workout plan " +
            "when beginning workout " +
            "then workout is started")
    @Test
    void beginWorkout() {
        //given
        var session = new WorkoutSession(events);
        var anyPlan = anyWorkoutPlan(new TraineeId(UUID.randomUUID()));

        //when
        var startedWorkout = session.beginWorkout(anyPlan);

        //then
        verify(events, times(1)).publish(any(WorkoutStarted.class));
        assertThat(startedWorkout).isNotNull();
    }

}
