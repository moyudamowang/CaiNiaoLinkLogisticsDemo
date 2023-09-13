package com.logistics.logisticssystem.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logistics.logisticssystem.config.ObjectMapperConfig;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class JsonUtil {

	private final static ObjectMapper objectMapper;

	static {
		objectMapper = new ObjectMapper();
		ObjectMapperConfig.buildObjectMapper(objectMapper);
	}


	
	public static String toJSONString(Object o) {
		return toJSONString(o, false);
	}

	
	public static String toJSONString(Object o, boolean format) {
		try {
			if (o == null) {
				return "";
			}
			if (o instanceof Number) {
				return o.toString();
			}
			if (o instanceof String) {
				return (String) o;
			}
			if (format) {
				return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
			}
			return objectMapper.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	
	public static <T> T toObject(String json, Class<T> cls) {
		if (!StringUtils.hasText(json) || cls == null) {
			return null;
		}
		try {
			return objectMapper.readValue(json, cls);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	
	public static <T> T toObject(String json, Class<?> parametrized, Class<?>... parameterClasses) {
		if (!StringUtils.hasText(json) || parametrized == null) {
			return null;
		}
		try {
			JavaType javaType = objectMapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
			return objectMapper.readValue(json, javaType);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	
	public static <T> T toObject(String json, TypeReference<T> typeReference) {
		if (!StringUtils.hasText(json) || typeReference == null) {
			return null;
		}
		try {
			return objectMapper.readValue(json, typeReference);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	
	public static byte[] toBytes(Object jsonValue) {
		if (jsonValue == null) {
			return null;
		}
		try {
			return objectMapper.writeValueAsBytes(jsonValue);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	
	public static <T> T convertObject(Object fromValue, Class<T> cls) {
		return objectMapper.convertValue(fromValue, cls);
	}

	
	public <T> T convertObject(Object fromValue, TypeReference<T> toValueTypeRef) {
		return objectMapper.convertValue(fromValue, toValueTypeRef);
	}

	
	public static <T> T toObject(byte[] obj, Class<T> cls) {
		try {
			return objectMapper.readValue(obj, cls);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	
	public static <T> T toObject(byte[] obj, TypeReference<T> toValueTypeRef) {
		try {
			return objectMapper.readValue(obj, toValueTypeRef);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	
	public static JsonNode parse(String json) {
		if (!StringUtils.hasText(json)) {
			return null;
		}
		try {
			return objectMapper.readTree(json);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	
	public static <K, V> Map<K, V> toMap(Object o) {
		if (o == null) {
			return null;
		}
		if (o instanceof String) {
			return toObject((String) o, Map.class);
		}
		return objectMapper.convertValue(o, Map.class);
	}

	
	public static <T> List<T> toList(String json) {
		if (!StringUtils.hasText(json)) {
			return null;
		}
		try {
			return objectMapper.readValue(json, new TypeReference<>() {
			});
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	
	public static <T> List<T> toList(String json, Class<T> cls) {
		if (!StringUtils.hasText(json)) {
			return null;
		}
		try {
			JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, cls);
			return objectMapper.readValue(json, javaType);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

}
