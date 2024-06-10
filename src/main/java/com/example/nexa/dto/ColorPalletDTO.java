package com.example.nexa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ColorPalletDTO {

    private int color_pallet_id;
    private String feedback;
    private String email;
    private String colors;
}
