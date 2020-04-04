package com.github.kjkow.workoutpartner.planning;

import com.github.kjkow.workoutpartner.commons.Event;
import lombok.NonNull;
import lombok.Value;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Value
public class WorkoutPlanned implements Event {
    @NonNull
    UUID aggregateId;
    @NonNull
    Instant created;
    @NonNull
    LocalDate forDay;
    @NonNull
    UUID forTrainee;
}
