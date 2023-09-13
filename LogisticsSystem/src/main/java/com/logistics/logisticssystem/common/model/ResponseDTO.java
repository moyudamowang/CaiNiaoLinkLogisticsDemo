package com.logistics.logisticssystem.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO implements Serializable {
    private static final long serialVersionUID = -5126112990898417085L;
    public final static String SUCCESS_DEFAULT_MESSAGE = "OK";
    public final static String FAIL_DEFAULT_MESSAGE = "FAIL";

    private int code = 0;
    private String message = "ok";
    private Object data;
}
