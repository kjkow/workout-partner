package com.github.kjkow.workoutpartner.planning;

import com.github.kjkow.workoutpartner.commons.Events;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.github.kjkow.workoutpartner.planning.Fixture.anyWorkoutPlan;
import static org.mockito.Mockito.*;

class WorkoutPlanTest {

    private final WorkoutPlanRepository repository = mock(WorkoutPlanRepository.class);
    private final Events events = mock(Events.class);

    @DisplayName("when new workout is planned, then" +
            "it is persisted in repository and" +
            "workout planned event is published")
    @Test
    void testPlan() {
        //given
        var unplannedWorkoutSession = new UnplannedWorkoutSession(repository, events);
        var traineeId = new TraineeId(UUID.randomUUID());
        var plan = anyWorkoutPlan(traineeId);

        //when
        var workoutPlannedEvent = unplannedWorkoutSession.planWorkout(plan);

        //then
        verify(repository, times(1)).addPlan(plan);
        verify(events, times(1)).publish(workoutPlannedEvent);
    }

}

