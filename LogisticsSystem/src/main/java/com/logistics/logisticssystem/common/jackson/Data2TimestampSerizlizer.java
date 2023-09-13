package com.logistics.logisticssystem.common.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

public class Data2TimestampSerizlizer extends JsonSerializer<Date> {
    public static final Data2TimestampSerizlizer INSTANCE = new Data2TimestampSerizlizer();
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        jsonGenerator.writeNumber(date.getTime());
    }
}
