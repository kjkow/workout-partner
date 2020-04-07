package com.github.kjkow.workoutpartner.planning;

import lombok.NonNull;
import lombok.Value;

import static com.github.kjkow.workoutpartner.planning.MeasurementUnit.KILOS;

enum MeasurementUnit {
    KILOS,
    POUNDS
}

@Value
class WorkoutRepetition {
    @NonNull
    Weight weight;

    static WorkoutRepetition ofKilograms(float kilos) {
        return new WorkoutRepetition(new Weight(KILOS, kilos));
    }
}

@Value
class Weight {
    @NonNull
    MeasurementUnit unit;
    @NonNull
    float value;
}
