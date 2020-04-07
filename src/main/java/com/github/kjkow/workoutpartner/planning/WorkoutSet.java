package com.github.kjkow.workoutpartner.planning;

import lombok.NonNull;
import lombok.Value;

import java.util.List;

@Value
class WorkoutSet {
    @NonNull
    List<WorkoutRepetition> workoutRepetitions;

    static WorkoutSet ofReps(List<WorkoutRepetition> reps) {
        return new WorkoutSet(reps);
    }
}
