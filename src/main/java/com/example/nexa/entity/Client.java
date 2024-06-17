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
    private String name;
    private String gender;
    private String b_date;
    private String user_group;
    private String password;
    @OneToMany(mappedBy = "client")
    private Set<InteriorImage> interiorImages;

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUser_group(String user_group) {
        this.user_group = user_group;
    }

    public String getBDate() {
        return b_date;
    }

    public void setBDate(String b_date) {
        this.b_date = b_date;
    }
}
