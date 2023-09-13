package com.logistics.logisticssystem.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.logistics.logisticssystem.common.enums.StandardEnumDeserializer;
import com.logistics.logisticssystem.common.enums.StandardEnumSerializer;
import com.logistics.logisticssystem.common.jackson.Data2TimestampSerizlizer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;


@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE + 10)
public class ObjectMapperConfig {

	static final DateTimeFormatter ISO_LOCAL_DATE_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@Bean
	@ConditionalOnMissingBean(ObjectMapper.class)
	public ObjectMapper objectMapper() {

		ObjectMapper objectMapper = new ObjectMapper();

		buildObjectMapper(objectMapper);

		return objectMapper;
	}

	
	public static void buildObjectMapper(ObjectMapper objectMapper) {

		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

		objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		//关闭反序列化的时候，没有找到属性的setter报错
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		//序列化的时候序列对象的所有属性
		objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
		//下划线转驼峰
//		objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		//反序列化的时候如果多了其他属性,不抛出异常
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//如果是空对象的时候,不抛异常
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		//把序列化和反序列化添加到对象中
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addDeserializer(Enum.class, StandardEnumDeserializer.INSTANCE);
		simpleModule.addSerializer(Enum.class, StandardEnumSerializer.INSTANCE);

		objectMapper
				.registerModule(simpleModule)
				.registerModule(timeModel());
	}

	
	private static SimpleModule timeModel() {
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(LocalDateTime.class, new com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer(ISO_LOCAL_DATE_TIME));
		simpleModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(ISO_LOCAL_DATE_TIME));
		simpleModule.addSerializer(LocalDate.class, new com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer(DateTimeFormatter.ISO_LOCAL_DATE));
		simpleModule.addDeserializer(LocalDate.class, new com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer(DateTimeFormatter.ISO_LOCAL_DATE));
		simpleModule.addSerializer(LocalTime.class, new com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer(DateTimeFormatter.ISO_LOCAL_TIME));
		simpleModule.addDeserializer(LocalTime.class, new com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer(DateTimeFormatter.ISO_LOCAL_TIME));
		simpleModule.addDeserializer(Instant.class, InstantDeserializer.INSTANT);
		simpleModule.addDeserializer(OffsetDateTime.class, InstantDeserializer.OFFSET_DATE_TIME);
		simpleModule.addDeserializer(ZonedDateTime.class, InstantDeserializer.ZONED_DATE_TIME);

		simpleModule.addSerializer(Date.class, Data2TimestampSerizlizer.INSTANCE);
		return simpleModule;
	}

}
