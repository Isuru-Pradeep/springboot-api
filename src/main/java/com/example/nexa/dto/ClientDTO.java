package com.example.nexa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDTO {
    private String email;
    private String name;
    private String gender;
    private String b_date;
    private String user_group;
    private String password;
}
