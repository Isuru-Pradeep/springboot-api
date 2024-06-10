package com.example.nexa.controller;

import com.example.nexa.dto.ClientDTO;
import com.example.nexa.dto.ColorPalletDTO;
import com.example.nexa.service.ColorPalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/colorpallet")
@CrossOrigin
public class ColorPalletControler {

    @Autowired
    private ColorPalletService colorPalletService ;
    @GetMapping("/getColorPalletById/{id}")
    public ColorPalletDTO getColorPalletById(@PathVariable String id){
        System.out.println("Color Pallet  Id :"+ id);
        return colorPalletService.getColorPallet(id);
    }
    @PostMapping("/saveColorpallet")
    public ColorPalletDTO saveColorPallet(@RequestBody ColorPalletDTO colorPalletDTO) {
        return colorPalletService.saveColorPallet(colorPalletDTO);
    }
}
