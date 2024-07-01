package com.example.nexa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(ColorPalletKey.class)
public class ColorPallet {
    @Id
    private int imageColorPalletId;
    @Id
    private String email;
    private String rating;

}
