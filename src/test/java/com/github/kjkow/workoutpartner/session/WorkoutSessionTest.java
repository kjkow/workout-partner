package com.github.kjkow.workoutpartner.session;

import com.github.kjkow.workoutpartner.commons.Events;
import com.github.kjkow.workoutpartner.planning.Fixture;
import com.github.kjkow.workoutpartner.planning.WorkoutSessionPlan;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class WorkoutSessionTest {

    private final Events events = mock(Events.class);

    private WorkoutSession session;
    private WorkoutSessionPlan anyWorkoutPlan;

    @DisplayName("given new workout session and any workout plan " +
            "when beginning workout " +
            "then workout is started")
    @Test
    void beginWorkout() {
        //given
        workoutSession();
        //and
        anyWorkoutPlan();

        //when
        var startedWorkout = session.beginWorkout(anyWorkoutPlan);

        //then
        verify(events, times(1)).publish(any(WorkoutStarted.class));
        //and
        assertThat(startedWorkout).isNotNull();
    }

    private void workoutSession() {
        session = new WorkoutSession(events);
    }

    private void anyWorkoutPlan() {
        anyWorkoutPlan = Fixture.anyWorkoutPlan();
    }

}
