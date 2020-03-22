package com.github.kjkow.workoutpartner.planning;

import lombok.NonNull;
import lombok.Value;

import java.util.List;

@Value
class Exercise {
    @NonNull
    String name;
    @NonNull
    List<WorkoutSet> workoutSets;
}
