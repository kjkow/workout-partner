package com.github.kjkow.workoutpartner.commons;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;

import static org.mockito.Mockito.*;

class EventsTest {

    private final EventStorage eventStorage = mock(EventStorage.class);
    private final Events eventPublisher = new Events(mock(ApplicationEventPublisher.class), eventStorage);

    private Event anyEvent;

    @DisplayName("when event is published then it should be saved in storage")
    @Test
    void saveTest() {
        //given
        anyEvent();

        //when
        eventPublisher.publish(anyEvent);

        //then
        verify(eventStorage, times(1)).store(anyEvent);
    }

    private void anyEvent() {
        anyEvent = mock(Event.class);
    }

}