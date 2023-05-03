package com.example.demo.controller;


import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.*;
import software.amazon.awssdk.services.s3.*;
import software.amazon.awssdk.services.s3.model.*;

@Controller
@RequestMapping("sub32")
public class Controller32 {
	
	@Value("${aws.accessKeyId}")
	private String accessKey;
	
	@Value("${aws.secretAccessKey}")
	private String secretKey;
	
	@Value("${aws.bucketName}")
	private String bucketName;
	
	@GetMapping("link1")
	public void mehtod1() {
		// s3 파일업로드
	       Region region = Region.AP_NORTHEAST_2;
	       
	       String fileName = "MyFile.txt";
	       String key = "test/"+ fileName;
	       String content = "새로운 파일 내용물1";
	       
	       AwsCredentials awsCredentials = AwsBasicCredentials.create(accessKey, secretKey);
	       S3Client s3 = S3Client.builder()
	    		   .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
	               .region(region)
	               .build();
	       
	       PutObjectRequest objectRequest = PutObjectRequest.builder()
	               .bucket(bucketName)
	               .acl(ObjectCannedACL.PUBLIC_READ)
	               .key(key)
	               .build();

	        s3.putObject(objectRequest,	RequestBody.fromBytes(content.getBytes()));
	}
}


