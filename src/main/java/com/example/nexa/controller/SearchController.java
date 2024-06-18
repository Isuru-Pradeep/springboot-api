package com.example.nexa.controller;

import com.example.nexa.dto.SearchDTO;
import com.example.nexa.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/search")
@CrossOrigin
public class SearchController {
    @Autowired
    private SearchService searchService;

    @GetMapping("/getData")
    public List<SearchDTO> getData() {
        return searchService.getAllData();
    }


    @PostMapping("/saveData")
    public SearchDTO saveData(@RequestBody SearchDTO SearchDTO) {
        return searchService.saveData(SearchDTO);
    }

    //complexity
    @GetMapping("/getDataByComplexity/{complexity}")
    public SearchDTO getDataByComplexity(@PathVariable String complexity){
        return searchService.getDataByComplexity(complexity);
    }
    //retrieve all data relevant to complexity
    @GetMapping("/getAllDataByComplexity/{complexity}")
    public List<SearchDTO> getAllDataByComplexity(@PathVariable String complexity){
        return searchService.getAllDataByComplexity(complexity);
    }
    //retrieve all data relevant to complexity
    @GetMapping("/getAllDataByAllValue/{complexity}/{texture}/{color}")
    public List<SearchDTO> getAllDataByAllValue(@PathVariable String complexity,@PathVariable String texture,@PathVariable String color){
        return searchService.getAllDataByAllValue(complexity,texture,color);
    }

}
