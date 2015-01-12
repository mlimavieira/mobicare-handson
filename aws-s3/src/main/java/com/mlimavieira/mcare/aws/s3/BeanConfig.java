package com.mlimavieira.mcare.aws.s3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;

@Configuration
public class BeanConfig {

	@Value("#{systemEnvironment['HANDSON_ACCESS_KEY']}")
	private String ACCESS_KEY;
	@Value("#{systemEnvironment['HANDSON_ACCESS_SECRET']}")
	private String ACCESS_SECRET;

	@Bean
	public AmazonS3Client getAmazonS3Client() {

		if (StringUtils.isEmpty(ACCESS_KEY)) {
			ACCESS_KEY = "AKIAI4LVAGHCUNKU3WOA";
		}
		if (StringUtils.isEmpty(ACCESS_SECRET)) {
			ACCESS_SECRET = "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";
		}
		return new AmazonS3Client(new BasicAWSCredentials(ACCESS_KEY, ACCESS_SECRET));
	}
}
