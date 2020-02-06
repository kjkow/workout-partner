package com.github.kjkow.workoutpartner.session;

import java.time.LocalDateTime;

class WorkoutSession {

    private LocalDateTime workoutStartTime;
    private final Trainee trainee;

    WorkoutSession(Trainee trainee) {
        this.trainee = trainee;
    }

    void beginWorkout(){
        workoutStartTime = LocalDateTime.now();
    }

    boolean isStarted() {
        return workoutStartTime != null;
    }
}
