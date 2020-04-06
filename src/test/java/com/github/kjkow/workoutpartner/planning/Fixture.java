package com.github.kjkow.workoutpartner.planning;

import java.time.LocalDate;
import java.util.List;

import static java.util.Collections.singletonList;

public class Fixture {
    public static LocalDate randomDate() {
        return LocalDate.of(2020, 3, 20); //TODO randomize
    }

    public static WorkoutSessionPlan anyWorkoutPlan(TraineeId traineeId) {
        var deadLiftRepetitionOne = new WorkoutRepetition(Weight.ofKilograms(200));
        var deadLiftRepetitionTwo = new WorkoutRepetition(Weight.ofKilograms(300));
        var deadLiftRepetitionThree = new WorkoutRepetition(Weight.ofKilograms(350));
        var deadLiftSet = new WorkoutSet(List.of(deadLiftRepetitionOne, deadLiftRepetitionTwo, deadLiftRepetitionThree));
        var exercises = singletonList(new Exercise("deadLift", singletonList(deadLiftSet)));
        return new WorkoutSessionPlan(exercises, randomDate(), traineeId);
    }
}
