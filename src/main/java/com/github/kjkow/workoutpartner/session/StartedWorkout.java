package com.github.kjkow.workoutpartner.session;

import com.github.kjkow.workoutpartner.commons.Events;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
class StartedWorkout {

    private final UUID workoutId;
    private final Events events;
    private final List<String> exercises;

    Result startExercise(String exercise) {
        if (exerciseIsNotOnTheList(exercise)) {
            return Result.failure("Exercise must be on plan");
        }

        events.publish(new ExerciseStarted(workoutId, Instant.now()));
        return Result.success();
    }

    private boolean exerciseIsNotOnTheList(String exercise) {
        return exercises
                .stream()
                .noneMatch(s -> s.equals(exercise));
    }
}
