package com.mlimavieira.mcare.aws.s3;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;

@SpringBootApplication
public class S3Sample {

	@Value("#{systemProperties['HANDSON_ACCESS_KEY']}")
	private String ACCESS_KEY;
	@Value("#{systemProperties['HANDSON_ACCESS_SECRET']}")
	private String ACCESS_SECRET;

	public static void main(String[] args) {

		SpringApplication.run(S3Sample.class, args);

	}

	@Bean
	public AmazonS3Client getAmazonS3Client() {
		return new AmazonS3Client(new BasicAWSCredentials(ACCESS_KEY,
				ACCESS_SECRET));
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println(ACCESS_KEY);
		System.out.println(ACCESS_SECRET);

	}
}
