package com.github.kjkow.workoutpartner.planning;

import com.github.kjkow.workoutpartner.commons.Events;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static com.github.kjkow.workoutpartner.planning.Fixture.randomDate;
import static java.util.Collections.singletonList;
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

    static WorkoutSessionPlan anyWorkoutPlan(TraineeId traineeId) {
        var deadLiftRepetitionOne = new WorkoutRepetition(Weight.ofKilograms(200));
        var deadLiftRepetitionTwo = new WorkoutRepetition(Weight.ofKilograms(300));
        var deadLiftRepetitionThree = new WorkoutRepetition(Weight.ofKilograms(350));
        var deadLiftSet = new WorkoutSet(List.of(deadLiftRepetitionOne, deadLiftRepetitionTwo, deadLiftRepetitionThree));
        var exercises = singletonList(new Exercise("deadLift", singletonList(deadLiftSet)));
        return new WorkoutSessionPlan(exercises, randomDate(), traineeId);
    }
}

