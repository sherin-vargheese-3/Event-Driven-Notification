package com.exercise.notificationsystem.events;

import lombok.Getter;

@Getter
public class ProductOutOfStockEvent {
    private final Long userId;
    public ProductOutOfStockEvent(Long userId) {
        this.userId = userId;
    }
}
