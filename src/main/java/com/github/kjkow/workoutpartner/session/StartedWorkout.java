package com.github.kjkow.workoutpartner.session;

import com.github.kjkow.workoutpartner.commons.Events;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
class StartedWorkout {

    private final UUID workoutId;
    private final Events events;

    void startExercise(String exercise) {
        //TODO is on the list?
        events.publish(new ExerciseStarted(workoutId, Instant.now()));
    }
}
