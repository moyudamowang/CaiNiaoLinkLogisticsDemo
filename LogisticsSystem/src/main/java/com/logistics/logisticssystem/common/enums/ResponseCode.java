package com.logistics.logisticssystem.common.enums;


public enum ResponseCode {

    SUCCESS(0),
    FAIL(-1),
    UNAUTHORIZED(403),
    INVALID(-2),
    UNAUTHENTICATION(401),
    NOT_FOUND(404),
    FAIL_FAST_ERROR(-996),
    ARGS_ERROR(-997),
    ARGS_VALIDATE_FAIL_ERROR(-998),
    INTERNAL_SERVER_ERROR(-999);

    private int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
