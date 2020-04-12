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

    private WorkoutPlanned workoutPlanned;
    private WorkoutPlannedNotification notificationHandler;

    @DisplayName("when workout is planned then notification is send")
    @Test
    void notificationTest() {
        //given
        workoutPlanned();
        //and
        notificationHandler();

        //when
        notificationHandler.handle(workoutPlanned);

        //then
        verify(notificationApi, times(1)).sendNotification(any());
    }

    private void workoutPlanned() {
        workoutPlanned = new WorkoutPlanned(UUID.randomUUID(), Instant.now(), randomDate(), UUID.randomUUID());
    }

    private void notificationHandler() {
        notificationHandler = new WorkoutPlannedNotification(notificationApi);
    }

}