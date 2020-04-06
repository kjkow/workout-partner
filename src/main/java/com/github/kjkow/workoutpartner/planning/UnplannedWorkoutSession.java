package com.github.kjkow.workoutpartner.planning;

import com.github.kjkow.workoutpartner.commons.Events;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.Instant;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
class UnplannedWorkoutSession {

    private final WorkoutPlanRepository repository;
    private final Events events;

    WorkoutPlanned planWorkout(WorkoutSessionPlan plan) {
        repository.addPlan(plan);
        var event = new WorkoutPlanned(plan.getWorkoutPlanId(), Instant.now(), plan.getForDay(), plan.getForTrainee().getId());
        events.publish(event);
        return event;
    }
}
