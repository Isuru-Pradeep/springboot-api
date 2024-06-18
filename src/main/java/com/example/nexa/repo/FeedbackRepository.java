package com.example.nexa.repo;

import com.example.nexa.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface FeedbackRepository extends JpaRepository<Feedback,Long> {

    Feedback nfeedback = new Feedback();

//    String comm = nfeedback.getComment();
//    String imurl = nfeedback.getComment();
//    @Query(value = "INSERT INTO feedback (comment,imgurl) VALUES(" +comm+","+imurl+");",nativeQuery = true);
//    @Query(value = "INSERT INTO feedback (comment,imgurl) VALUES(?1 ,?2);",comm,imurl,nativeQuery = true);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO feedback (comment, s3url) VALUES (:comment, :s3url)", nativeQuery = true)
    void insertFeedback(@Param("comment") String comment, @Param("s3url") String imgurl);
}

