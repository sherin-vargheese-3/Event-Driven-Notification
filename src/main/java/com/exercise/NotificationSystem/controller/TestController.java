package com.exercise.NotificationSystem.controller;

import com.exercise.NotificationSystem.events.OrderPlacedEvent;
import com.exercise.NotificationSystem.events.ProductOutOfStockEvent;
import com.exercise.NotificationSystem.events.UserRegisteredEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String triggerUserRegistered(@RequestParam Long userId) {
        publisher.publishEvent(new UserRegisteredEvent(userId));
        return "Event published!";
    }

    @PostMapping("/order")
    public String triggerOrderPlaced(@RequestParam Long userId) {
        publisher.publishEvent(new OrderPlacedEvent(userId));
        return "Order placed.";
    }

    @PostMapping("/out-of-stock")
    public String triggerProductOutOfStock(@RequestParam Long userId) {
        publisher.publishEvent(new ProductOutOfStockEvent(userId));
        return "Product out of stock.";
    }
}
