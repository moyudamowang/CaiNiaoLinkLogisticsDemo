package com.logistics.logisticssystem.common.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public interface StandardEnum extends IEnum<Integer> {

  String DEFAULT_VALUE_NAME = "value";

  String DEFAULT_LABEL_NAME = "label";


  @Override
  @JsonValue
  default Integer getValue() {
    Field field = ReflectionUtils.findField(this.getClass(), DEFAULT_VALUE_NAME);
    if (field == null) {
      return null;
    }
    try {
      field.setAccessible(true);
      return Integer.parseInt(field.get(this).toString());
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  
  default String getLabel() {
    Field field = ReflectionUtils.findField(this.getClass(), DEFAULT_LABEL_NAME);
    if (field == null) {
      return null;
    }
    try {
      field.setAccessible(true);
      return field.get(this).toString();
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  
  static <T extends Enum<T>> T valueOfEnum(Class<T> clz, Integer value) {
    if (value == null) {
      throw new IllegalArgumentException(clz.getName() + " value should not be null");
    }
    if (clz.isAssignableFrom(StandardEnum.class)) {
      throw new IllegalArgumentException("illegal StandardEnum type");
    }
    T[] enums = clz.getEnumConstants();
    for (T t : enums) {
      StandardEnum displayedEnum = (StandardEnum) t;
      if (displayedEnum.getValue().equals(value)) {
        return t;
      }
    }
    throw new IllegalArgumentException("cannot parse integer: " + value + " to " + clz.getName());
  }


  static <T extends Enum<T>> T labelOfEnum(Class<T> clz, String label) {
    if (label == null) {
      throw new IllegalArgumentException(clz.getName() + " value should not be null");
    }
    if (clz.isAssignableFrom(StandardEnum.class)) {
      throw new IllegalArgumentException("illegal StandardEnum type");
    }
    T[] enums = clz.getEnumConstants();
    for (T t : enums) {
      StandardEnum displayedEnum = (StandardEnum) t;
      if (displayedEnum.getLabel().equals(label)) {
        return t;
      }
    }
    throw new IllegalArgumentException("cannot parse string: " + label + " to " + clz.getName());
  }

  
  static <T extends Enum<T>> List<EnumerationModel> convert2bean(Class<T> clz){
    if (clz.isAssignableFrom(StandardEnum.class)) {
      throw new IllegalArgumentException("illegal StandardEnum type");
    }
    T[] enums = clz.getEnumConstants();
    List models = new ArrayList<EnumerationModel>();
    for (T t : enums) {
      StandardEnum displayedEnum = (StandardEnum) t;
      models.add(new EnumerationModel(displayedEnum.getValue(),displayedEnum.getLabel()));
    }
    return models;
  }
}
