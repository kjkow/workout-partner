package com.github.kjkow.workoutpartner.commons;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@AllArgsConstructor
public class Events {

    private final ApplicationEventPublisher eventPublisher;
    private final EventStorage eventStorage;

    void publish(Event event) {
        eventPublisher.publishEvent(event);
        eventStorage.store(event);
    }
}
