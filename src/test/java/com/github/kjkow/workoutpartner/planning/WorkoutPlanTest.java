package com.github.kjkow.workoutpartner.planning;

import com.github.kjkow.workoutpartner.commons.Events;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class WorkoutPlanTest {

    private final WorkoutSessionPlanRepository repository = mock(WorkoutSessionPlanRepository.class);
    private final Events events = mock(Events.class);

    private UnplannedWorkoutSession unplannedWorkoutSession;
    private WorkoutSessionPlan anyWorkoutPlan;

    @DisplayName("when new workout is planned, then" +
            "it is persisted in repository and" +
            "workout planned event is published")
    @Test
    void testPlan() {
        //given
        unplannedWorkoutSession();
        //and
        anyWorkoutPlan();

        //when
        var workoutPlannedEvent = unplannedWorkoutSession.planWorkout(anyWorkoutPlan);

        //then
        verify(repository, times(1)).save(anyWorkoutPlan);
        verify(events, times(1)).publish(workoutPlannedEvent);
    }

    private void unplannedWorkoutSession() {
        unplannedWorkoutSession = new UnplannedWorkoutSession(repository, events);
    }

    private void anyWorkoutPlan() {
        anyWorkoutPlan = Fixture.anyWorkoutPlan();
    }

}

