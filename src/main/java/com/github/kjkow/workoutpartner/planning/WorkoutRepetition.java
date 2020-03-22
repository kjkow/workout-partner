package com.github.kjkow.workoutpartner.planning;

import lombok.Value;

enum MeasurementUnit {
    KILOS,
    POUNDS
}

@Value
class WorkoutRepetition {
    Weight weight;
}

@Value
class Weight {
    MeasurementUnit unit;
    float value;

    static Weight ofKilograms(float value) {
        return new Weight(MeasurementUnit.KILOS, value);
    }
}
