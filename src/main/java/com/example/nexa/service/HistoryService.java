package com.example.nexa.service;

import com.example.nexa.dto.HistoryDTO;
import com.example.nexa.dto.InteriorImageDTO;
import com.example.nexa.entity.ColorPallet;
import com.example.nexa.entity.InteriorImage;
import com.example.nexa.repo.ColorPalletRepo;
import com.example.nexa.repo.InteriorImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class HistoryService {

    @Autowired
    private InteriorImageRepo interiorImageRepository;
    @Autowired
    private ColorPalletRepo colorPalletRepository;

    public List<HistoryDTO> getHistory(String email) {
        List<InteriorImage> images = interiorImageRepository.findByEmail(email);

        return images.stream().map(image -> {
            HistoryDTO dto = new HistoryDTO();
            dto.setImage(image.getImageUrl());
            List<String> palette = colorPalletRepository.findByImageColorPalletId(image.getId())
                    .stream()
                    .map(ColorPallet::getColorCode)
                    .collect(Collectors.toList());
            dto.setPalette(palette);
            return dto;
        }).collect(Collectors.toList());


    }

    public void clearHistory(String email) {
        List<InteriorImage> images = interiorImageRepository.findByClientEmail(email);
        interiorImageRepository.deleteAll(images);
    }

    private InteriorImageDTO convertToDTO(InteriorImage image) {
        InteriorImageDTO dto = new InteriorImageDTO();
        dto.setAugmentedImage(image.getAugmentedImage());
        dto.setTexture(image.getTexture());
        dto.setComplexityScore(image.getComplexityScore());
        dto.setInteriorType(image.getInteriorType());
        dto.setImageUrl(image.getImageUrl());
        return dto;
    }


}
