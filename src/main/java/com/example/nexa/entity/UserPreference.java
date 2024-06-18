package com.example.nexa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String budget;
    private String favoriteColors; // Comma-separated list of hex codes
    private String  numberOfMembers;
    private String climate;
    private String lifestyle;
    private String architecturalStyle;
    private boolean photosensitivity;
    private boolean naturalLightChecked;
    private boolean richColorChecked;
    private String colorToneTheme;
    private String preferredAmbiance;
    private String gender;
    private String ageGroup;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getFavoriteColors() {
        return favoriteColors;
    }

    public void setFavoriteColors(String favoriteColors) {
        this.favoriteColors = favoriteColors;
    }

    public String getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(String numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(String lifestyle) {
        this.lifestyle = lifestyle;
    }

    public String getArchitecturalStyle() {
        return architecturalStyle;
    }

    public void setArchitecturalStyle(String architecturalStyle) {
        this.architecturalStyle = architecturalStyle;
    }

    public boolean isPhotosensitivity() {
        return photosensitivity;
    }

    public void setPhotosensitivity(boolean photosensitivity) {
        this.photosensitivity = photosensitivity;
    }

    public boolean isNaturalLightChecked() {
        return naturalLightChecked;
    }

    public void setNaturalLightChecked(boolean naturalLightChecked) {
        this.naturalLightChecked = naturalLightChecked;
    }

    public boolean isRichColorChecked() {
        return richColorChecked;
    }

    public void setRichColorChecked(boolean richColorChecked) {
        this.richColorChecked = richColorChecked;
    }

    public String getColorToneTheme() {
        return colorToneTheme;
    }

    public void setColorToneTheme(String colorToneTheme) {
        this.colorToneTheme = colorToneTheme;
    }

    public String getPreferredAmbiance() {
        return preferredAmbiance;
    }

    public void setPreferredAmbiance(String preferredAmbiance) {
        this.preferredAmbiance = preferredAmbiance;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    // Additional helper methods for favoriteColors as List

    public List<String> getFavoriteColorsList() {
        return favoriteColors == null ? new ArrayList<>() : Arrays.asList(favoriteColors.split(","));
    }

    public void setFavoriteColorsList(List<String> favoriteColorsList) {
        this.favoriteColors = String.join(",", favoriteColorsList);
    }
}
