package com.example.nexa.controller;

import com.example.nexa.dto.HistoryDTO;
import com.example.nexa.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @GetMapping("/{email}")
    public ResponseEntity<List<HistoryDTO>> getHistory(@PathVariable String email) {
        List<HistoryDTO> images = historyService.getHistory(email);
        if (images.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(images);
    }
}
