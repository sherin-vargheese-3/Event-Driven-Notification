package com.exercise.notificationsystem.service;

import com.exercise.notificationsystem.events.OrderPlacedEvent;
import com.exercise.notificationsystem.events.ProductOutOfStockEvent;
import com.exercise.notificationsystem.events.UserRegisteredEvent;
import com.exercise.notificationsystem.model.Notification;
import com.exercise.notificationsystem.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationListener {

    @Autowired
    private NotificationRepository notificationRepository;

    @EventListener
    @Async
    public void handleUserRegistered(UserRegisteredEvent event) {
        Notification notification = new Notification();
        notification.setUserId(event.getUserId());
        notification.setType("WELCOME");
        notification.setMessage("Welcome to our app!");
        notification.setRead(false);
        notification.setCreatedAt(LocalDateTime.now());
        notificationRepository.save(notification);
    }

    @EventListener
    @Async
    public void handleOrderPlaced(OrderPlacedEvent event) {
        Notification notification = new Notification();
        notification.setUserId(event.getUserId());
        notification.setType("ORDER");
        notification.setMessage("Your order has been placed!");
        notification.setRead(false);
        notification.setCreatedAt(LocalDateTime.now());
        notificationRepository.save(notification);
    }

    @EventListener
    @Async
    public void handleProductOutOfStock(ProductOutOfStockEvent event) {
        Notification notification = new Notification();
        notification.setUserId(event.getUserId());
        notification.setType("OUT_OF_STOCK");
        notification.setMessage("Product is out of stock!");
        notification.setRead(false);
        notification.setCreatedAt(LocalDateTime.now());
        notificationRepository.save(notification);
    }
}
