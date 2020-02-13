package com.github.kjkow.workoutpartner.session;

import java.time.LocalDateTime;

class WorkoutSession {

    private final Trainee trainee;
    private final WorkoutSessionPlan workoutSessionPlan;
    private LocalDateTime workoutStartTime;

    WorkoutSession(Trainee trainee, WorkoutSessionPlan workoutSessionPlan) {
        this.trainee = trainee;
        this.workoutSessionPlan = workoutSessionPlan;
    }

    void beginWorkout() {
        workoutStartTime = LocalDateTime.now();
    }

    boolean isStarted() {
        return workoutStartTime != null;
    }
}
