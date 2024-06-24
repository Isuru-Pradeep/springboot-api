package com.example.nexa.service;

import com.example.nexa.dto.OutputImageDTO;
import com.example.nexa.entity.OutputImage;
import com.example.nexa.repo.OuptputImageRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OutputImageService {

    @Autowired
    private OuptputImageRepo searchRepo;

    @Autowired
    private ModelMapper modelMapper;

    public OutputImageDTO saveData(OutputImageDTO searchDTO){
        searchRepo.save(modelMapper.map(searchDTO, OutputImage.class));
        return searchDTO;
    }
    public List<OutputImageDTO> getAllData(){
        List<OutputImage>searchList=searchRepo.findAll();
        return modelMapper.map(searchList,new TypeToken<List<OutputImageDTO>>(){}.getType());
    }

    //complexity
    public OutputImageDTO getDataByComplexity(String complexity){
        OutputImage search=searchRepo.getDataByComplexity(complexity);
        return modelMapper.map(search, OutputImageDTO.class);
    }
    //retrieve all data relevant to complexity
    public List<OutputImageDTO> getAllDataByComplexity(String complexity){
        List<OutputImage> searches = searchRepo.getAllDataByComplexity(complexity);
        // Map each Search entity to SearchDTO
        return searches.stream()
                .map(search -> modelMapper.map(search, OutputImageDTO.class))
                .collect(Collectors.toList());
    }

//    public List<SearchDTO> getAllDataByAllValue(String complexity,String texture,String color){
//        List<Search> searches = searchRepo.getAllDataByAllValue(complexity,texture,color);
//        // Map each Search entity to SearchDTO
//        return searches.stream()
//                .map(search -> modelMapper.map(search, SearchDTO.class))
//                .collect(Collectors.toList());
//    }

//    public List<SearchDTO> getAllDataByAllValue(String complexity, String texture, String color) {
//        List<Search> searches = searchRepo.getAllDataByAllValue(
//                "All".equalsIgnoreCase(complexity) ? null : complexity,
//                "All".equalsIgnoreCase(texture) ? null : texture,
//                "All".equalsIgnoreCase(color) ? null : color
//        );
//        System.out.println(complexity + texture + color);
//
//        // Map each Search entity to SearchDTO
//        return searches.stream()
//                .map(search -> modelMapper.map(search, SearchDTO.class))
//                .collect(Collectors.toList());
//    }


    public List<OutputImageDTO> getAllDataByAllValue(String complexity, String texture, String finalColor) {
        List<OutputImage> searches = searchRepo.getAllDataByAllValue(
                "All".equalsIgnoreCase(complexity) ? null : complexity,
                "All".equalsIgnoreCase(texture) ? null : texture,
                "All".equalsIgnoreCase(finalColor) ? null : finalColor
        );

        // Map each Search entity to SearchDTO
        return searches.stream()
                .map(search -> modelMapper.map(search, OutputImageDTO.class))
                .collect(Collectors.toList());
    }



}
