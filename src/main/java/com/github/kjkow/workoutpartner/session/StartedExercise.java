package com.github.kjkow.workoutpartner.session;

import com.github.kjkow.workoutpartner.commons.Events;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
class StartedExercise {

    private final UUID workoutId;
    private final Events events;

    // todo workout plan elements are loaded by external responsibility when loading classes such this one
    // if no of sets exceed planned one
    // priv fin NumberOfSets setsCount - loaded from workout plan externally

    Result startSet() {
        return Result.success();
    }

}
