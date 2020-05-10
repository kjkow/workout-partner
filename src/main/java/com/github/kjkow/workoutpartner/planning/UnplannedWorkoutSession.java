package com.github.kjkow.workoutpartner.planning;

import com.github.kjkow.workoutpartner.commons.Events;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Instant;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
class UnplannedWorkoutSession {

    private final WorkoutSessionPlanRepository repository;
    private final Events events;

    WorkoutPlanned planWorkout(WorkoutSessionPlan plan) {
        repository.save(plan);
        var event = new WorkoutPlanned(plan.getWorkoutPlanId(), Instant.now(), plan.getForDay(), plan.getForTrainee().getId());
        events.publish(event);
        return event;
    }
}
