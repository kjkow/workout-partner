package com.github.kjkow.workoutpartner.planning;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
class SessionPlanning {

    private final WorkoutPlanRepository repository;

    void planWorkout(WorkoutSessionPlan plan) {
        repository.addPlan(plan);
        //TODO publish event
    }
}
