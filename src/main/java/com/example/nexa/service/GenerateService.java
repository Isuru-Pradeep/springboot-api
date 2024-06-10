package com.example.nexa.service;

import com.example.nexa.dto.ClientDTO;
import com.example.nexa.dto.GenerateDTO;
import com.example.nexa.entity.Client;
import com.example.nexa.entity.Generate;
import com.example.nexa.repo.GenerateRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GenerateService {
    @Autowired
    private GenerateRepo generateRepo;
    @Autowired
    private ModelMapper modelMapper;

    public GenerateDTO getGenerate(String email, String id,String color_pallet_id){
        Generate generate =generateRepo.getGenerate(email, id, color_pallet_id);
        return modelMapper.map(generate,GenerateDTO.class);
    }
    public List<GenerateDTO> getAllGenerates(){
        List<Generate>generateList = generateRepo.findAll();
        return modelMapper.map(generateList,new TypeToken<List<GenerateDTO>>(){}.getType());
    }
}
