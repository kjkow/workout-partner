package com.github.kjkow.workoutpartner.commons;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;

import static org.mockito.Mockito.*;

class EventsTest {

    @DisplayName("when event is published then it should be saved in storage")
    @Test
    void saveTest() {
        //given
        var eventStorage = mock(EventStorage.class);
        var events = new Events(mock(ApplicationEventPublisher.class), eventStorage);
        var event = mock(Event.class);

        //when
        events.publish(event);

        //then
        verify(eventStorage, times(1)).store(event);
    }

}