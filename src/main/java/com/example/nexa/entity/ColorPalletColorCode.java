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
@IdClass(ColorPalletColorCodeKey.class)
public class ColorPalletColorCode {
    @Id
    private String email;
    @Id
    private int ColorPalletColorId;
    private String ColorCode;

}
