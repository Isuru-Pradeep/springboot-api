package com.example.nexa.controller;

import com.example.nexa.entity.UserPreference;
import com.example.nexa.service.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserPreferenceController {

    @Autowired
    private UserPreferenceService userPreferenceService;

    @PostMapping("/saveUserPreference")
    public ResponseEntity<UserPreference> saveUserPreference(@RequestBody UserPreference userPreference) {
        UserPreference savedPreference = userPreferenceService.saveUserPreference(userPreference);
        return ResponseEntity.ok(savedPreference);
    }
}
