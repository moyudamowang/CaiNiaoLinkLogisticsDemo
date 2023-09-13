package com.logistics.logisticssystem.common.enums;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;


@SuppressWarnings("rawtypes")
public class StandardEnumSerializer extends JsonSerializer<Enum> {
  public static final StandardEnumSerializer INSTANCE = new StandardEnumSerializer();
  @Override
  public void serialize(Enum value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
    if (value == null) {
      return;
    }
    if (value instanceof StandardEnum) {
      jsonGenerator.writeNumber(((StandardEnum) value).getValue());
    } else {
      jsonGenerator.writeString(value.name());
    }
  }
}
