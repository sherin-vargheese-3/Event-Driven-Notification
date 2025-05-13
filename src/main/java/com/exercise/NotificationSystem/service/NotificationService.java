package com.exercise.NotificationSystem.service;

import com.exercise.NotificationSystem.model.Notification;
import com.exercise.NotificationSystem.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getNotifications(Long userId) {
        return notificationRepository.findByUserId(userId);
    }
}
