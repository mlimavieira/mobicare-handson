package com.mlimavieira.mcare.aws.dynamodb.marshaller;

import java.util.List;

import org.springframework.util.StringUtils;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMarshaller;
import com.google.gson.Gson;

public class AddressMarshaller implements DynamoDBMarshaller<List<Address>> {

	@Override
	public String marshall(final List<Address> address) {

		if (address == null) {
			return "";
		}
		return new Gson().toJson(address);
	}

	@Override
	public List<Address> unmarshall(final Class<List<Address>> clazz, final String address) {

		if (StringUtils.isEmpty(address)) {
			return null;
		}

		return new Gson().fromJson(address, List.class);
	}

}
