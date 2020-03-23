package com.github.kjkow.workoutpartner.planning;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
class SessionPlanning {

    private final WorkoutPlanRepository repository;
    private final PlanningEvents events;

    void planWorkout(WorkoutSessionPlan plan) {
        repository.addPlan(plan);
        events.publish();//TODO actual event
    }
}
