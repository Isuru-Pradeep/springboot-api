package com.example.nexa.repo;

import com.example.nexa.entity.OutputImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OuptputImageRepo extends JpaRepository<OutputImage,Integer> {
    //Complexity
    @Query(value = "SELECT * FROM search WHERE complexity = ?1",nativeQuery = true)
    OutputImage getDataByComplexity(String complexity);
    //Texture
    @Query(value = "SELECT * FROM search WHERE texture = ?1",nativeQuery = true)
    OutputImage getDataByTexture(String texture);
    //Color
    @Query(value = "SELECT * FROM search WHERE color = ?1",nativeQuery = true)
    OutputImage getDataByColor(String color);
    //retrieve all data relevant to complexity
    @Query(value = "SELECT * FROM search WHERE complexity = ?1", nativeQuery = true)
    List<OutputImage> getAllDataByComplexity(String complexity);
    //retrieve all data relevant to complexity
//    @Query(value = "SELECT * FROM search WHERE complexity = ?1 AND texture = ?2 AND color=?3", nativeQuery = true)
//    List<Search> getAllDataByAllValue(String complexity,String texture,String color);

//    //good search
//    @Query(value = "SELECT augmented_image FROM interior_image " +
//            "WHERE " +
//            "(CASE WHEN ?1 = 'All' THEN TRUE ELSE complexity = ?1 END OR ?1 IS NULL) " +
//            "AND (CASE WHEN ?2 = 'All' THEN TRUE ELSE texture = ?2 END OR ?2 IS NULL) " +
//            "AND (CASE WHEN ?3 = 'All' THEN TRUE ELSE final_color = ?3 END OR ?3 IS NULL)",
//            nativeQuery = true)
//    List<Search> getAllDataByAllValue(String complexity, String texture, String color);



    @Query(value = "SELECT * FROM output_image " +
                "WHERE " +
                "(CASE WHEN :param1 = 'All' THEN TRUE ELSE complexity = :param1 END OR :param1 IS NULL) " +
                "AND (CASE WHEN :param2 = 'All' THEN TRUE ELSE texture = :param2 END OR :param2 IS NULL) " +
                "AND (CASE WHEN :param3 = 'All' THEN TRUE ELSE final_color = :param3 END OR :param3 IS NULL)",
                nativeQuery = true)
    List<OutputImage> getAllDataByAllValue(@Param("param1") String complexity,
                                           @Param("param2") String texture,
                                           @Param("param3") String finalColor);


}
