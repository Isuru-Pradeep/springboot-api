package com.example.nexa.repo;

import com.example.nexa.entity.ColorPallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColorPalletRepo extends JpaRepository<ColorPallet,String> {
    @Query(value = "SELECT * FROM color_pallet WHERE color_pallet_id =?1",nativeQuery = true)
    ColorPallet getColorPallet(String id);

    List<ColorPallet> findByImageColorPalletId(int imageColorPalletId);

    List<ColorPallet> findByEmail(String email);

}
