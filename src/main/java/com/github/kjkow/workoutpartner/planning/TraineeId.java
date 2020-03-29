package com.github.kjkow.workoutpartner.planning;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class TraineeId {
    @NonNull
    UUID id;
}
