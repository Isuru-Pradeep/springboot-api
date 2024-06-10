package com.example.nexa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

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

//    @OneToOne
//    @JoinColumn(name = "email", referencedColumnName = "email")
//    private Client client;

}
