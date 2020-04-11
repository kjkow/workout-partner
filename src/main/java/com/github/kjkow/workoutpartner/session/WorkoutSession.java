package com.github.kjkow.workoutpartner.session;

import com.github.kjkow.workoutpartner.commons.Events;
import com.github.kjkow.workoutpartner.planning.Exercise;
import com.github.kjkow.workoutpartner.planning.WorkoutSessionPlan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Instant;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
class WorkoutSession {

    private final Events events;

    public StartedWorkout beginWorkout(WorkoutSessionPlan sessionPlan) {
        var sessionId = UUID.randomUUID();
        var event = new WorkoutStarted(sessionId, Instant.now());
        events.publish(event);
        var exercises = sessionPlan.getExercises()
                .stream()
                .map(Exercise::getName)
                .collect(Collectors.toList());

        return new StartedWorkout(sessionId, events, exercises);
    }
}
