package com.github.kjkow.workoutpartner.planning;

import com.github.kjkow.workoutpartner.commons.Event;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

import java.time.Instant;
import java.util.UUID;

@Value
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class WorkoutPlanned implements Event {
    @NonNull
    UUID aggregateId;
    @NonNull
    Instant created;
}
