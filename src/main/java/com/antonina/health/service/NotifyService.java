package com.antonina.health.service;

import com.antonina.health.domain.User;
import com.antonina.health.repository.UserRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotifyService {

    private final UserRepository userRepository;
    private final JavaMailSender emailSender;

    public NotifyService(UserRepository userRepository, JavaMailSender emailSender) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    @Scheduled(cron = "0 1 */1 * * *")
    public void sendNotifications() {
        int hour = LocalDateTime.now().getHour();
        List<User> notifyUsers = userRepository.findByNotifyHourAndActiveTrue(hour);

        for (User user : notifyUsers) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(user.getEmail());
            message.setSubject("Senior Health - notify");
            message.setText("Hi! Insert new data.");
            emailSender.send(message);
        }
    }
}