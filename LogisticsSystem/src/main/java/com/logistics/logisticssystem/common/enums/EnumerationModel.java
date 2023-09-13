package com.logistics.logisticssystem.common.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnumerationModel implements Serializable {
    private Integer value;
    private String label;
}
