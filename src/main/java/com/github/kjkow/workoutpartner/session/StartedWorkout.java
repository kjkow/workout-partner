package com.github.kjkow.workoutpartner.session;

import com.github.kjkow.workoutpartner.commons.Events;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
class StartedWorkout {
    @NonNull
    private final UUID workoutId;

    private final Events events;


    public void startExercise(String exercise) {
        //TODO is on the list?
        events.publish(new ExerciseStarted(workoutId, Instant.now()));
    }
}
