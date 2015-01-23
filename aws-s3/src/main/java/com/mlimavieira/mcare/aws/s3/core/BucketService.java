package com.mlimavieira.mcare.aws.s3.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.DeleteBucketRequest;

@Component
public class BucketService {

	@Autowired
	private AmazonS3Client clientS3;

	public boolean bucketExists(String bucketName) {
		if (StringUtils.isEmpty(bucketName)) {
			throw new IllegalArgumentException("BucketName is required");
		}

		final String bucketLocation = clientS3.getBucketLocation(bucketName);
		return !StringUtils.isEmpty(bucketLocation);
	}

	public void createBucket(final String bucketName) {

		if (StringUtils.isEmpty(bucketName)) {
			throw new IllegalArgumentException("BucketName is required");
		}

		final CreateBucketRequest bucketRequest = new CreateBucketRequest(bucketName);
		clientS3.createBucket(bucketRequest);
	}

	public void deleteBucket(final String bucketName) {

		if (StringUtils.isEmpty(bucketName)) {
			throw new IllegalArgumentException("BucketName is required");
		}

		final DeleteBucketRequest bucketRequest = new DeleteBucketRequest(bucketName);
		clientS3.deleteBucket(bucketRequest);
	}

}
