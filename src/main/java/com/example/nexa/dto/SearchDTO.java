package com.example.nexa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SearchDTO {
    private String email;
    private String complexity;
    private String texture;
    private String color;
    private String imgurl;

}
