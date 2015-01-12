package com.mlimavieira.mcare.aws.s3.core;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.mlimavieira.mcare.aws.s3.S3Sample;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = S3Sample.class)
public class BucketServiceTest {

	@Autowired
	private BucketService bucketService;

	private String defaultBucketName;

	private String testBucketName;

	@Before
	public void beforeTest() {

		BasicConfigurator.configure();
		defaultBucketName = RandomStringUtils.randomAlphabetic(10).toLowerCase();
		testBucketName = RandomStringUtils.randomAlphabetic(10).toLowerCase();

		bucketService.createBucket(testBucketName);
	}

	@After
	public void afterTest() {

		final ObjectListing listObjects = bucketService.listObjects(testBucketName);
		for (final S3ObjectSummary row : listObjects.getObjectSummaries()) {
			bucketService.deleteObject(row.getBucketName(), row.getKey());
		}

		bucketService.deleteBucket(testBucketName);
	}

	@Test
	public void createBucket() {

		bucketService.createBucket(defaultBucketName);
	}

	@Test
	public void deleteBucket() {

		bucketService.createBucket(defaultBucketName);
	}

	@Test
	public void putObject() {

		bucketService.putObject(testBucketName, "teste.txt", "TESTE TESTE".getBytes(), "application/text");

	}
}
