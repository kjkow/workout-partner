package com.github.kjkow.workoutpartner.session;

import com.github.kjkow.workoutpartner.commons.Events;
import com.github.kjkow.workoutpartner.planning.WorkoutSessionPlan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
class WorkoutSession {

    private final Events events;

    public StartedWorkout beginWorkout(WorkoutSessionPlan sessionPlan) {
        var sessionId = UUID.randomUUID();
        var event = new WorkoutStarted(sessionId, Instant.now());
        events.publish(event);
        return new StartedWorkout(sessionId);
    }
}
