package com.huyvu.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {

	@Override
	public LocalDateTime convert(String source) {

		return LocalDateTime.parse(source, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

}
