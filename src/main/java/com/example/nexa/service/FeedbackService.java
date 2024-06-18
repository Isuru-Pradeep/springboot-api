package com.example.nexa.service;

import lombok.extern.slf4j.Slf4j;
import com.example.nexa.entity.Feedback;
import com.example.nexa.repo.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;
    Feedback newfb = new Feedback();

    public void saveFeedback(String comment,String url){

        String s3updatedUrl = "https://feedbackimages3.s3.amazonaws.com/"+url;
//        String comment = newfb.getComment();

        feedbackRepository.insertFeedback(s3updatedUrl, comment);
        //log.info("updated ok feedback");
    }
}
