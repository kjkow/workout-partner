package com.github.kjkow.workoutpartner.commons;

import java.time.Instant;
import java.util.UUID;

public interface Event {

    UUID aggregateId();

    Instant created();
}
