package com.example.nexa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class InteriorImageDTO {
    private String email;
    private int id;
    private String augmented_image;
    private String texture;
    private float complexity_score;
    private String interior_type;
    private String image_url;
}


