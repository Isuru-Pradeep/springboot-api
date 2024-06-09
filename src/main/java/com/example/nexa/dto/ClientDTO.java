package com.example.nexa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDTO {
    private String email;
    private String gender;
    private String bDate;
    private String user_group;
    private String password;
}
