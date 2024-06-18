package com.example.nexa.service;

import com.example.nexa.dto.SearchDTO;
import com.example.nexa.entity.Search;
import com.example.nexa.repo.SearchRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SearchService {

    @Autowired
    private SearchRepo searchRepo;

    @Autowired
    private ModelMapper modelMapper;

    public SearchDTO saveData(SearchDTO searchDTO){
        searchRepo.save(modelMapper.map(searchDTO, Search.class));
        return searchDTO;
    }
    public List<SearchDTO> getAllData(){
        List<Search>searchList=searchRepo.findAll();
        return modelMapper.map(searchList,new TypeToken<List<SearchDTO>>(){}.getType());
    }

    //complexity
    public SearchDTO getDataByComplexity(String complexity){
        Search search=searchRepo.getDataByComplexity(complexity);
        return modelMapper.map(search,SearchDTO.class);
    }
    //retrieve all data relevant to complexity
    public List<SearchDTO> getAllDataByComplexity(String complexity){
        List<Search> searches = searchRepo.getAllDataByComplexity(complexity);
        // Map each Search entity to SearchDTO
        return searches.stream()
                .map(search -> modelMapper.map(search, SearchDTO.class))
                .collect(Collectors.toList());
    }

    public List<SearchDTO> getAllDataByAllValue(String complexity,String texture,String color){
        List<Search> searches = searchRepo.getAllDataByAllValue(complexity,texture,color);
        // Map each Search entity to SearchDTO
        return searches.stream()
                .map(search -> modelMapper.map(search, SearchDTO.class))
                .collect(Collectors.toList());
    }
}
