package com.example.nexa.controller;

import com.example.nexa.dto.ClientDTO;
import com.example.nexa.dto.GenerateDTO;
import com.example.nexa.service.GenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/generate")
@CrossOrigin
public class GenerateController {
    @Autowired
    private GenerateService generateService;
    @GetMapping("/getGenerate/{email}/{id}/{color_pallet_id}")
    public GenerateDTO getGenerate(@PathVariable String email , @PathVariable String id, @PathVariable String color_pallet_id){
        System.out.println("Email :"+ email +"ID :" +id+" Color_pallet_id :"+color_pallet_id);
        return generateService.getGenerate(email,id,color_pallet_id);
    }
    @GetMapping("/getGenerates")
    public List<GenerateDTO> getGenerates(){
        return generateService.getAllGenerates();
    }
}
