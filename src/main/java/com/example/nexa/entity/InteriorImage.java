package com.example.nexa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@IdClass(InteriorImageKey.class)
public class InteriorImage {
    @Id
    private String email;
    @Id
    private int InteriorImageId;
    private String augmentedImageUrl;
    private String texture;
    private float complexityScore;
    private String TimeStamp;
    private String InteriorImageUrl;

//    @ManyToOne
//    @MapsId("email")
//    @JoinColumn(name = "email")
//    private Client client;



}
