package com.github.kjkow.workoutpartner.session;


import lombok.Value;

import java.util.List;

@Value
class WorkoutSessionPlan {
    Trainee trainee;
    List<WorkoutSet> workoutSets;
}
