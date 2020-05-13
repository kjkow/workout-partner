package com.github.kjkow.workoutpartner.planning;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static java.util.Collections.singletonList;

public class Fixture {

    public static LocalDate randomDate() {
        return LocalDate.of(
                randomIntegerWithRange(1990, 2020),
                randomIntegerWithRange(1, 12),
                randomIntegerWithRange(1, 28));
    }

    private static int randomIntegerWithRange(int min, int max) {
        var randomInt = new Random().ints(min, max).findFirst();
        return randomInt.orElse(0);
    }

    public static WorkoutSessionPlan anyWorkoutPlan() {
        var deadLiftRepetitionOne = WorkoutRepetition.ofKilograms(200);
        var deadLiftRepetitionTwo = WorkoutRepetition.ofKilograms(300);
        var deadLiftRepetitionThree = WorkoutRepetition.ofKilograms(350);

        var reps = List.of(deadLiftRepetitionOne, deadLiftRepetitionTwo, deadLiftRepetitionThree);
        var deadLiftSet = WorkoutSet.ofReps(reps);
        var exercises = singletonList(new Exercise("deadLift", singletonList(deadLiftSet)));

        return new WorkoutSessionPlan(UUID.randomUUID(), exercises, randomDate(), new TraineeId(UUID.randomUUID()));
    }
}
