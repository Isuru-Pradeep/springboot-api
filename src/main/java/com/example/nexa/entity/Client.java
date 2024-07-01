package com.example.nexa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {
    @Id
    private String email;
    private String gender;
    private String birthDate;
    private String userGroup;
    private String password;
    private String feedbackComment;
    private String feedbackImageUrl;
    private String feedbackAnswer1;
    private String feedbackAnswer2;
    private String feedbackAnswer3;
    private String feedbackAnswer4;
//    @OneToMany(mappedBy = "client")
//    private Set<InteriorImage> interiorImages;

}
