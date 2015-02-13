package com.mlimavieira.mcare.aws.dynamodb.marshaller;

import org.apache.commons.lang3.math.NumberUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMarshaller;

public class DateTimeMarshaller implements DynamoDBMarshaller<DateTime> {

	private static final Logger LOG = LoggerFactory.getLogger(DateTimeMarshaller.class);
	@Override
	public String marshall(final DateTime dateTime) {

		if (dateTime == null) {
			return null;
		}
		return String.valueOf(dateTime.getMillis());
	}

	@Override
	public DateTime unmarshall(final Class<DateTime> clazz, final String strDateTime) {

		if (StringUtils.isEmpty(strDateTime)) {
			return null;
		}

		if( !NumberUtils.isNumber(strDateTime)) {
			LOG.error("Unexpected DateTime Format. Expected Long type and received: {}", strDateTime);
			return null;
		}
		return new DateTime(Long.parseLong(strDateTime));
	}

}
