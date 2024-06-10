package com.example.nexa.controller;

import com.example.nexa.dto.GenerateDTO;
import com.example.nexa.dto.InteriorImageDTO;
import com.example.nexa.service.InteriorImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/interiorimage")
@CrossOrigin
public class InteriorImageController {
    @Autowired
    private InteriorImageService interiorImageService;
    @PostMapping("/saveInteriorImage")
    public InteriorImageDTO saveInteriorImage(@RequestBody InteriorImageDTO interiorImageDTO) {
        return interiorImageService.saveInteriorImage(interiorImageDTO);
    }

    @GetMapping("/getInteriorByEmailAndId/{email}/{id}")
    public InteriorImageDTO getInteriorBYEmailAndId(@PathVariable String email , @PathVariable String id){
        System.out.println("Email :"+ email +"ID :" +id+" Color_pallet_id :");
        return interiorImageService.getInteriorBYEmailAndId(email,id);
    }
}
