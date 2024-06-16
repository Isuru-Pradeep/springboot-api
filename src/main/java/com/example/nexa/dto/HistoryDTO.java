package com.example.nexa.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HistoryDTO {
    private String image;
    private List<String> palette;

    // Getters and Setters
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getPalette() {
        return palette;
    }

    public void setPalette(List<String> palette) {
        this.palette = palette;
    }
}
