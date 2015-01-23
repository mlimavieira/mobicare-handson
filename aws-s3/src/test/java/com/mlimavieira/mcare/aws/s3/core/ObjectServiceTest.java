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
public class ObjectServiceTest {

	@Autowired
	private ObjectService objectService;

	private String testBucketName;

	@Before
	public void beforeTest() {

		BasicConfigurator.configure();
		testBucketName = RandomStringUtils.randomAlphabetic(10).toLowerCase();

	}

	@After
	public void afterTest() {

		final ObjectListing listObjects = objectService.listObjects(testBucketName);
		for (final S3ObjectSummary row : listObjects.getObjectSummaries()) {
			objectService.deleteObject(row.getBucketName(), row.getKey());
		}

	}

	@Test
	public void putObject() {

		objectService.putObject(testBucketName, "teste.txt", "TESTE TESTE".getBytes(), "application/text");

	}
}
