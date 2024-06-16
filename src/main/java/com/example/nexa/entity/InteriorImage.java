package com.example.nexa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@IdClass(InteriorKey.class)
public class InteriorImage {
    @Id
    private String email;
    @Id
    private int id;
    private String augmented_image;
    private String texture;
    private float complexity_score;
    private String interior_type;
    private String image_url;

    @ManyToOne
    @MapsId("email")
    @JoinColumn(name = "email")
    private Client client;

    // Getters
    public String getAugmentedImage() {
        return augmented_image;
    }

    public String getTexture() {
        return texture;
    }

    public float getComplexityScore() {
        return complexity_score;
    }

    public String getInteriorType() {
        return interior_type;
    }

    public String getImageUrl(){
        return image_url;
    }

    public int getId() {
        return id;
    }
}
