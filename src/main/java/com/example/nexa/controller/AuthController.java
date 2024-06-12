package com.example.nexa.controller;

import com.example.nexa.entity.Client;
import com.example.nexa.repo.ClientRepo;
import com.example.nexa.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private EmailService emailService;

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        Client client = clientRepo.findByEmail(email);
        System.out.println(email);
        if (client == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        String newPassword = generateRandomPassword();
        client.setPassword(newPassword); // Ensure to encode the password using a password encoder
        clientRepo.save(client);
        String dateAndTime = timeAndDate();

        emailService.sendEmail(client.getEmail(), "New Password", "Your new password is: " + newPassword+"\nTime stamp : "+dateAndTime);

        return ResponseEntity.ok("Email sent");
    }

    private String generateRandomPassword() {
        int length = 6; // Length of the password


        String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
        String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String DIGITS = "0123456789";
        String SPECIAL = "@#$&";

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Define the character pool
        String combinedChars = LOWERCASE + UPPERCASE + DIGITS + SPECIAL;

        // Generate password
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(combinedChars.length());
            password.append(combinedChars.charAt(randomIndex));
        }
        return password.toString();
    }
    private String timeAndDate(){
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define a formatter to format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return currentDateTime.format(formatter);
    }
}
