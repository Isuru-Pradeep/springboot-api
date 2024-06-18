package com.example.nexa.repo;

import com.example.nexa.entity.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SearchRepo extends JpaRepository<Search,String> {
    //Complexity
    @Query(value = "SELECT * FROM search WHERE complexity = ?1",nativeQuery = true)
    Search getDataByComplexity(String complexity);
    //Texture
    @Query(value = "SELECT * FROM search WHERE texture = ?1",nativeQuery = true)
    Search getDataByTexture(String texture);
    //Color
    @Query(value = "SELECT * FROM search WHERE color = ?1",nativeQuery = true)
    Search getDataByColor(String color);
    //retrieve all data relevant to complexity
    @Query(value = "SELECT * FROM search WHERE complexity = ?1", nativeQuery = true)
    List<Search> getAllDataByComplexity(String complexity);
    //retrieve all data relevant to complexity
    @Query(value = "SELECT * FROM search WHERE complexity = ?1 AND texture = ?2 AND color=?3", nativeQuery = true)
    List<Search> getAllDataByAllValue(String complexity,String texture,String color);
}
