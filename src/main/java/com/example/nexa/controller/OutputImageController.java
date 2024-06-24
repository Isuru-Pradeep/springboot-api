package com.example.nexa.controller;

import com.example.nexa.dto.OutputImageDTO;
import com.example.nexa.service.OutputImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/outputimage")
@CrossOrigin
public class OutputImageController {
    @Autowired
    private OutputImageService searchService;

    @GetMapping("/getData")
    public List<OutputImageDTO> getData() {
        return searchService.getAllData();
    }


    @PostMapping("/saveData")
    public OutputImageDTO saveData(@RequestBody OutputImageDTO SearchDTO) {
        return searchService.saveData(SearchDTO);
    }

    //complexity
    @GetMapping("/getDataByComplexity/{complexity}")
    public OutputImageDTO getDataByComplexity(@PathVariable String complexity){
        return searchService.getDataByComplexity(complexity);
    }
    //retrieve all data relevant to complexity
    @GetMapping("/getAllDataByComplexity/{complexity}")
    public List<OutputImageDTO> getAllDataByComplexity(@PathVariable String complexity){
        return searchService.getAllDataByComplexity(complexity);
    }
    //retrieve all data relevant to complexity
//    @GetMapping("/getAllDataByAllValue/{complexity}/{texture}/{color}")
//    public List<SearchDTO> getAllDataByAllValue(@PathVariable String complexity,@PathVariable String texture,@PathVariable String color){
//        return searchService.getAllDataByAllValue(complexity,texture,color);
//    }

//    @GetMapping("/getAllDataByAllValue/{complexity}/{texture}/{color}")
//    public List<SearchDTO> getAllDataByAllValue(
//            @PathVariable String complexity,
//            @PathVariable String texture,
//            @PathVariable String color
//    ) {
//        // Check if parameters are "All" and adjust accordingly
//        if ("All".equalsIgnoreCase(complexity)) {
//            complexity = "All"; // or null, depending on your logic
//        }
//        if ("All".equalsIgnoreCase(texture)) {
//            texture = "All"; // or null
//        }
//        if ("All".equalsIgnoreCase(color)) {
//            color = "All"; // or null
//        }
//
//        return searchService.getAllDataByAllValue(complexity, texture, color);
//    }

    @GetMapping("/getAllDataByAllValue/{complexity}/{texture}/{finalColor}")
    public List<OutputImageDTO> getAllDataByAllValue(
            @PathVariable String complexity,
            @PathVariable String texture,
            @PathVariable String finalColor
    ) {
        // Check if parameters are "All" and adjust accordingly
        if ("All".equalsIgnoreCase(complexity)) {
            complexity = null; // or handle it as per your logic
        }
        if ("All".equalsIgnoreCase(texture)) {
            texture = null; // or handle it as per your logic
        }
        if ("All".equalsIgnoreCase(finalColor)) {
            finalColor = null; // or handle it as per your logic
        }

        return searchService.getAllDataByAllValue(complexity, texture, finalColor);
    }

}
