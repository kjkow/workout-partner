package com.github.kjkow.workoutpartner.planning;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

class WorkoutPlanInMemoRepository implements WorkoutPlanRepository {

    private final Set<WorkoutSessionPlan> workoutSessionPlans = new HashSet<>();

    @Override
    public void addPlan(WorkoutSessionPlan plan) {
        workoutSessionPlans.add(plan);
    }

    @Override
    public Optional<WorkoutSessionPlan> findBy(TraineeId traineeId) {
        return workoutSessionPlans.stream().filter(plan -> plan.getForTrainee().equals(traineeId)).findFirst();
    }
}
