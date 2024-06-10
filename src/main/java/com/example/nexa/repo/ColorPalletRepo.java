package com.example.nexa.repo;

import com.example.nexa.entity.ColorPallet;
import com.example.nexa.entity.Generate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ColorPalletRepo extends JpaRepository<ColorPallet,String> {
    @Query(value = "SELECT * FROM color_pallet WHERE color_pallet_id =?1",nativeQuery = true)
    ColorPallet getColorPallet(String id);
}
