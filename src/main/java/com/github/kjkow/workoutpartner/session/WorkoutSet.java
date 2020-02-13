package com.github.kjkow.workoutpartner.session;

import lombok.Value;

import java.util.List;

@Value
class WorkoutSet {
    String exerciseName;
    List<WorkoutRepetition> workoutRepetitions;
}
