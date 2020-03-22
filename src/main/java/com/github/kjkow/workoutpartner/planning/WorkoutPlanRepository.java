package com.github.kjkow.workoutpartner.planning;


import java.util.Optional;

public interface WorkoutPlanRepository {

    void addPlan(WorkoutSessionPlan plan);

    Optional<WorkoutSessionPlan> findBy(TraineeId traineeId);
}
