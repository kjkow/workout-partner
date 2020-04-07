package com.github.kjkow.workoutpartner.planning;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.singletonList;

public class Fixture {

    public static LocalDate randomDate() {
        return LocalDate.of(2020, 3, 20); //TODO randomize
    }

    public static WorkoutSessionPlan anyWorkoutPlan() {
        var deadLiftRepetitionOne = WorkoutRepetition.ofKilograms(200);
        var deadLiftRepetitionTwo = WorkoutRepetition.ofKilograms(300);
        var deadLiftRepetitionThree = WorkoutRepetition.ofKilograms(350);

        var reps = List.of(deadLiftRepetitionOne, deadLiftRepetitionTwo, deadLiftRepetitionThree);
        var deadLiftSet = WorkoutSet.ofReps(reps);
        var exercises = singletonList(new Exercise("deadLift", singletonList(deadLiftSet)));

        return new WorkoutSessionPlan(exercises, randomDate(), new TraineeId(UUID.randomUUID()));
    }
}
