package com.github.kjkow.workoutpartner.workout;

class WorkoutSession {

    private boolean started;

    static WorkoutSession begin() {
        return new WorkoutSession();
    }

    private WorkoutSession() {
        started = true;
    }

    boolean isStarted() {
        return started;
    }
}
