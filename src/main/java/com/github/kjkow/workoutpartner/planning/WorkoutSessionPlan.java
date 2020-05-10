package com.github.kjkow.workoutpartner.planning;


import lombok.NonNull;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Value
public class WorkoutSessionPlan {
    @NonNull
    UUID workoutPlanId;
    @NonNull
    List<Exercise> exercises;
    @NonNull
    LocalDate forDay;
    @NonNull
    TraineeId forTrainee;
}
