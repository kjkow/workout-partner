package com.github.kjkow.workoutpartner.planning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

class WorkoutPlanTest {

    @DisplayName("should add new workout plan")
    @Test
    void testPlan() {
        //given
        var repository = new WorkoutPlanInMemoRepository();
        PlanningEvents events = mock(PlanningEvents.class);
        var sessionPlanning = new SessionPlanning(repository, events);
        var traineeId = new TraineeId(UUID.randomUUID());

        //when
        sessionPlanning.planWorkout(anyWorkoutPlan(traineeId));

        //then
        assertTrue(repository.findBy(traineeId).isPresent());
        Mockito.verify(events, times(1)).publish();
    }

    static WorkoutSessionPlan anyWorkoutPlan(TraineeId traineeId) {
        var deadLiftRepetitionOne = new WorkoutRepetition(Weight.ofKilograms(200));
        var deadLiftRepetitionTwo = new WorkoutRepetition(Weight.ofKilograms(300));
        var deadLiftRepetitionThree = new WorkoutRepetition(Weight.ofKilograms(350));
        var deadLiftSet = new WorkoutSet(List.of(deadLiftRepetitionOne, deadLiftRepetitionTwo, deadLiftRepetitionThree));
        var exercises = singletonList(new Exercise("deadLift", singletonList(deadLiftSet)));
        return new WorkoutSessionPlan(exercises, LocalDate.of(2020, 3, 20), traineeId);
    }
}

