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


    // Setters
    public void setAugmentedImage(String augmentedImage) {
        this.augmented_image = augmentedImage;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public void setComplexityScore(float complexityScore) {
        this.complexity_score = complexityScore;
    }

    public void setInteriorType(String interiorType) {
        this.interior_type = interiorType;
    }

    public void setImageUrl(String image_url){
        this.image_url =image_url;
    }
}


