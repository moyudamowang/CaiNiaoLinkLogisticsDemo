package com.logistics.logisticssystem.common.enums;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;


@SuppressWarnings("rawtypes")
public class StandardEnumDeserializer extends StdDeserializer<Enum> implements ContextualDeserializer {

	public static final StandardEnumDeserializer INSTANCE = new StandardEnumDeserializer(Enum.class);

	protected StandardEnumDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Enum deserialize(JsonParser p, DeserializationContext ctx)
			throws IOException {

		JsonToken curr = p.currentToken();
		Class cls = _enumClass();
		// string
		if (curr == JsonToken.VALUE_STRING) {
			String str = p.getText().trim();
			if (str.length() == 0) {
				return null;
			}
			return Enum.valueOf(cls, p.getText().trim());
		}

		// int
		if (curr == JsonToken.VALUE_NUMBER_INT) {
			if (StandardEnum.class.isAssignableFrom(cls)) {
				return StandardEnum.valueOfEnum(cls, p.getIntValue());
			} else {
				throw ctx.weirdNumberException(p.getIntValue(), _enumClass(), "the enum is not 'StandardEnum',no supports number value");
			}
		}
		return (Enum) _deserializeOther(p, ctx);
	}

	protected Object _deserializeOther(JsonParser p, DeserializationContext ctxt) throws IOException {
		// [databind#381]
		if (p.hasToken(JsonToken.START_ARRAY)) {
			return _deserializeFromArray(p, ctxt);
		}
		return ctxt.handleUnexpectedToken(_enumClass(), p);
	}

	protected Class<?> _enumClass() {
		return handledType();
	}

	@Override
	public JsonDeserializer<?> createContextual(DeserializationContext ctx, BeanProperty property) {
		Class rawClass = ctx.getContextualType().getRawClass();
		return new StandardEnumDeserializer(rawClass);
	}
}
