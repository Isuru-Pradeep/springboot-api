package com.example.nexa.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@Slf4j
public class StoreageService {
    @Autowired
    FeedbackService feedbackService;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    @Value("${aws.accessKeyId}")
    private String accessKeyId;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Value("${aws.region}")
    private String region;

    public String upload(MultipartFile file) {
        File fileObj = convertMultiPartFileToFile(file);
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        try {
            s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
            return "File Uploaded: " + fileName;
        } catch (Exception e) {
            //log.error("Error uploading file to S3", e);
            throw new RuntimeException("Error uploading file to S3", e);
        } finally {
            fileObj.delete();
        }
    }

    public byte[] downloadFile(String fileName) {
        try {
            S3Object s3Object = s3Client.getObject(bucketName, fileName);
            S3ObjectInputStream inputStream = s3Object.getObjectContent();
            return IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            //log.error("Error downloading file from S3", e);
            throw new RuntimeException("Error downloading file from S3", e);
        }
    }

    public void deleteFile(String fileName) {
        try {
            s3Client.deleteObject(bucketName, fileName);
        } catch (Exception e) {
            //log.error("Error deleting file from S3", e);
            throw new RuntimeException("Error deleting file from S3", e);
        }
    }

    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            //log.error("Error converting multipart file to file", e);
            throw new RuntimeException("Error converting multipart file to file", e);
        }
        return convertedFile;
    }

    //upload file and input
    public String uploadFileComment(MultipartFile file, String userInput) {
        File fileObj = convertMultiPartFileToFile(file);
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        try {
            uploadToS3(fileObj, fileName);
            // Process user input or store it as needed
            //log.info("User input: {}", userInput);
            //log.info("File Name: {}", fileName);
            //passing to the feedback
//            Feedback newfeedback = new Feedback();
//            newfeedback.setComment(userInput);
//            newfeedback.setS3url(fileName);

            feedbackService.saveFeedback(userInput,fileName);
            return fileName; // Return the filename or other success indicator
        } catch (Exception e) {
            //log.error("Error uploading file to S3", e);
            throw new RuntimeException("Error uploading file to S3", e);
        } finally {
            fileObj.delete();
        }
    }
    private void uploadToS3(File file, String fileName) {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKeyId, secretKey);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.fromName(region))
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
        try {
            s3Client.putObject(new PutObjectRequest(bucketName, fileName, file));
        } catch (Exception e) {
            //log.error("Error uploading file to S3", e);
            throw new RuntimeException("Error uploading file to S3", e);
        }
    }
}
