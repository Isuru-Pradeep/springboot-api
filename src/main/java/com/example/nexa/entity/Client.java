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
    private String bDate;
    private String user_group;
    private String password;
    @OneToMany(mappedBy = "client")
    private Set<InteriorImage> interiorImages;

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String newPassword) {
        this.password =newPassword;
    }

    public String getPassword() {
        return this.password;
    }
}
