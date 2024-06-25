package com.example.nexa.controller;

import com.example.nexa.dto.HistoryDTO;
import com.example.nexa.repo.ClientRepo;
import com.example.nexa.repo.ColorPalletRepo;
import com.example.nexa.repo.GenerateRepo;
import com.example.nexa.repo.InteriorImageRepo;
import com.example.nexa.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;
    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private InteriorImageRepo interiorImageRepo;
    @Autowired
    private GenerateRepo generateRepo;
    @Autowired
    private ColorPalletRepo colorPalletRepo;

    @GetMapping("/{email}")
    public ResponseEntity<List<HistoryDTO>> getHistory(@PathVariable String email) {
        List<HistoryDTO> images = historyService.getHistory(email);
        if (images.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(images);
    }
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> clearHistory(@PathVariable String email) {
        if (clientRepo.existsById(email)) {
            interiorImageRepo.deleteAll(interiorImageRepo.findByClientEmail(email));
            colorPalletRepo.deleteAll(colorPalletRepo.findByEmail(email));
            generateRepo.deleteAll(generateRepo.findByEmail(email));

            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
