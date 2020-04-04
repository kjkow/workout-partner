package com.github.kjkow.workoutpartner.commons.notification;

import com.github.kjkow.workoutpartner.planning.WorkoutPlanned;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
class WorkoutPlannedNotification {

    private final NotificationApi notificationApi;

    @EventListener
    void handle(WorkoutPlanned event) {
        var notification = new Notification(
                event.getForTrainee(),
                "Workout for " + event.getForDay() + " is planned");
        notificationApi.sendNotification(notification);
    }
}
