package com.example.nexa.service;

import com.example.nexa.dto.GenerateDTO;
import com.example.nexa.dto.InteriorImageDTO;
import com.example.nexa.entity.Generate;
import com.example.nexa.entity.InteriorImage;
import com.example.nexa.repo.InteriorImageRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class InteriorImageService {
    @Autowired
    private InteriorImageRepo interiorImageRepo;
    @Autowired
    private ModelMapper modelMapper;

    public InteriorImageDTO saveInteriorImage(InteriorImageDTO interiorImageDTO) {
        interiorImageRepo.save(modelMapper.map(interiorImageDTO, InteriorImage.class));
        return interiorImageDTO;
    }
    public InteriorImageDTO getInteriorBYEmailAndId(String email, String id){
        InteriorImage interiorImage =interiorImageRepo.getInteriorBYEmailAndId(email, id);
        return modelMapper.map(interiorImage,InteriorImageDTO.class);
    }

}
