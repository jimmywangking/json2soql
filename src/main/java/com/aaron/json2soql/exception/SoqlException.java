package com.aaron.json2soql.exception;

import com.aaron.json2soql.enums.ErrorCodeEnums;

public class SoqlException extends RuntimeException {

    private String code;

    public SoqlException(String code, String message) {
        super(message);
        this.code = code;
    }

    public SoqlException(ErrorCodeEnums resultEnum) {
        super(resultEnum.getReason());
        this.code = resultEnum.getCode();
    }
}
