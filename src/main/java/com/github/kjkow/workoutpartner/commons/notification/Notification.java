package com.github.kjkow.workoutpartner.commons.notification;

import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
public class Notification {
    @NonNull
    UUID notificatorId;
    @NonNull
    String notificationMessage;
}
