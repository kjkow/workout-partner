package com.github.kjkow.workoutpartner.session;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
class StartedWorkout {
    @NonNull
    private final UUID workoutId;
}
