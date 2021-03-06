package com.mlimavieira.mcare.aws.s3.core;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

@Component
public class ObjectService {
	@Autowired
	private AmazonS3Client clientS3;

	public void putObject(final String bucketName, final String objectName, final byte[] bytes, final String contentType) {

		if (bytes.length == 0) {
			throw new IllegalArgumentException("The parameter Bytes must be specified");
		}

		final ObjectMetadata metadata = new ObjectMetadata();
		if (StringUtils.isEmpty(contentType)) {
			metadata.setContentType(contentType);
		}
		metadata.setContentLength(bytes.length);

		final PutObjectRequest request = new PutObjectRequest(bucketName, objectName, new ByteArrayInputStream(bytes), metadata);

		clientS3.putObject(request);
	}

	public S3Object getObject(final String bucketName, final String objectKey) {

		final GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, objectKey);
		return clientS3.getObject(getObjectRequest);
	}

	public ObjectListing listObjects(final String bucketName) {

		final ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
		listObjectsRequest.withBucketName(bucketName);

		return clientS3.listObjects(listObjectsRequest);
	}

	public void deleteObject(String bucketName, String objectName) {
		final DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(bucketName, objectName);

		clientS3.deleteObject(deleteObjectRequest);
	}

}
