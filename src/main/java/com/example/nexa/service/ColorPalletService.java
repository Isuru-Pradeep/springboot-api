package com.example.nexa.service;

import com.example.nexa.dto.ColorPalletDTO;
import com.example.nexa.entity.ColorPallet;
import com.example.nexa.repo.ColorPalletRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ColorPalletService {
    @Autowired
    private ColorPalletRepo colorPalletRepo;
    @Autowired
    private ModelMapper modelMapper;

    public ColorPalletDTO saveColorPallet(ColorPalletDTO colorpalletDTO) {
        colorPalletRepo.save(modelMapper.map(colorpalletDTO, ColorPallet.class));
        return colorpalletDTO;
    }

    public ColorPalletDTO getColorPallet(String id){
        ColorPallet colorPallet = colorPalletRepo.getColorPallet(id);
        return modelMapper.map(colorPallet, ColorPalletDTO.class);
    }

}
