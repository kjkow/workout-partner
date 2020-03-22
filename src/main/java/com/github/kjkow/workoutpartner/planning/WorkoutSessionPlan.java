package com.github.kjkow.workoutpartner.planning;


import lombok.NonNull;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class WorkoutSessionPlan {
    @NonNull
    List<Exercise> exercises;
    @NonNull
    LocalDate forDay;
    @NonNull
    TraineeId forTrainee;
}
