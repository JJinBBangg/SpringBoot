package com.example.demo.controller;

import java.io.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import jakarta.annotation.*;
import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.awscore.exception.*;
import software.amazon.awssdk.core.exception.*;
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

	private S3Client s3;

	@PostConstruct
	public void init() {
		Region region = Region.AP_NORTHEAST_2;
		AwsCredentials awsCredentials = AwsBasicCredentials.create(accessKey, secretKey);
		this.s3 = S3Client.builder().credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
				.region(region).build();
		;
	}

	@GetMapping("link1")
	public void mehtod1(String fileName) {
		// s3 파일 업로드

		String key = "test/uuuuu/" + fileName;
		String content = "새로운 파일 내용물12";

		PutObjectRequest objectRequest = PutObjectRequest.builder().bucket(bucketName).acl(ObjectCannedACL.PUBLIC_READ)
				.key(key).build();

		s3.putObject(objectRequest, RequestBody.fromBytes(content.getBytes()));
	}

	@GetMapping("link2")
	public void method2() {
		// s3 파일 삭제

		String fileName = "MyFile.txt";
		String key = "test/" + fileName;

		DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder().bucket(bucketName).key(key).build();

		s3.deleteObject(deleteObjectRequest);
	}

	@GetMapping("link3")
	public void method3() {

	}

	@PostMapping("link4")
	public void method4(List<MultipartFile> files) {
		if (files.size() > 0)
			files.stream().forEach((file) -> {
				String key = "test/" + file.getOriginalFilename();
				PutObjectRequest objectRequest = PutObjectRequest.builder()
						.bucket(bucketName)
						.acl(ObjectCannedACL.PUBLIC_READ)
						.key(key)
						.build();

					System.out.println(key);
					try {
						s3.putObject(objectRequest, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
						System.out.println("업로드");
					} catch (AwsServiceException | SdkClientException | IOException e) {
						System.out.println("업로드 실패");
						e.printStackTrace();
					}
	
			});
	}
	@PostMapping("link5")
	public void method5(String[] fileNames) {
		if(fileNames.length >0)Arrays.asList(fileNames).stream().forEach((fileName)->{
			String key = "test/" + fileName;
			DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest
					.builder()
					.bucket(bucketName)
					.key(key)
					.build();
			
			s3.deleteObject(deleteObjectRequest);
		});
	}
}
