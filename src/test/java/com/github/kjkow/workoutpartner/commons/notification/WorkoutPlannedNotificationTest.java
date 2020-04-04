package com.github.kjkow.workoutpartner.commons.notification;

import com.github.kjkow.workoutpartner.planning.WorkoutPlanned;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static com.github.kjkow.workoutpartner.planning.Fixture.randomDate;
import static org.mockito.Mockito.*;

class WorkoutPlannedNotificationTest {

    private final NotificationApi notificationApi = mock(NotificationApi.class);

    @DisplayName("when workout is planned then notification is send")
    @Test
    void notificationTest() {
        //given
        var event = workoutPlannedEvent();
        var handler = new WorkoutPlannedNotification(notificationApi);

        //when
        handler.handle(event);

        //then
        verify(notificationApi, times(1)).sendNotification(any());
    }

    private WorkoutPlanned workoutPlannedEvent() {
        return new WorkoutPlanned(UUID.randomUUID(), Instant.now(), randomDate(), UUID.randomUUID());
    }

}