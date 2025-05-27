package com.exercise.notificationsystem.events;

import lombok.Getter;

@Getter
public class OrderPlacedEvent {
    private final Long userId;
    public OrderPlacedEvent(Long userId) {
        this.userId = userId;
    }
}
