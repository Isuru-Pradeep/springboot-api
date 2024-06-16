package com.example.nexa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ColorPallet {
    @Id
    @Column(name = "color_pallet_id")
    private int imageColorPalletId;
    private String feedback;
    private String email;
    private String colors;

    public String getColorCode() {
        return colors;
    }
}
