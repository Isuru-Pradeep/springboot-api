package com.example.nexa.repo;

import com.example.nexa.entity.Generate;
import com.example.nexa.entity.MyKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenerateRepo extends JpaRepository<Generate, MyKey> {
    @Query(value = "SELECT * FROM generate WHERE email =?1 AND id =?2 AND color_pallet_id =?3",nativeQuery = true)
    Generate getGenerate(String email, String id, String color_pallet_id);

    List<Generate> findByEmail(String email);
}
