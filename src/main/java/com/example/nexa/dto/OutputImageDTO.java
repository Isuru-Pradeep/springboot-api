package com.example.nexa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OutputImageDTO {
    private int id;
    private String email;
    private String complexity;
    private String texture;
    private String final_color;
    private String augmented_image;

}
