package com.mlimavieira.mcare.aws.dynamodb.model;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMarshalling;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.mlimavieira.mcare.aws.dynamodb.marshaller.AddressMarshaller;

@DynamoDBTable(tableName = "sampleUser")
public class User {

	@DynamoDBHashKey
	private String email;
	@DynamoDBAttribute
	private String name;

	@DynamoDBMarshalling(marshallerClass = AddressMarshaller.class)
	@DynamoDBAttribute(attributeName = "address")
	private List<Address> address;

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(final List<Address> address) {
		this.address = address;
	}

}
