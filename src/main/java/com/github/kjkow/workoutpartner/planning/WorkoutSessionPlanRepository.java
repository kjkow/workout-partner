package com.github.kjkow.workoutpartner.planning;


import java.util.Optional;

public interface WorkoutSessionPlanRepository {

    void save(WorkoutSessionPlan plan);

    Optional<WorkoutSessionPlan> findBy(TraineeId traineeId);
}
