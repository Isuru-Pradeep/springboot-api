package com.example.nexa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

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

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String newPassword) {
        this.password =newPassword;
    }
}
