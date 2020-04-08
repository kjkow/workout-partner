package com.github.kjkow.workoutpartner.session;

import com.github.kjkow.workoutpartner.commons.Event;
import lombok.NonNull;
import lombok.Value;

import java.time.Instant;
import java.util.UUID;

@Value
class ExerciseStarted implements Event {
    @NonNull
    UUID aggregateId;
    @NonNull
    Instant created;
}
