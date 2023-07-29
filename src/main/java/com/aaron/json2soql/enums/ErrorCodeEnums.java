package com.aaron.json2soql.enums;

public enum ErrorCodeEnums  {

    JASON_FORMAT_ERROR("JSON2SOQL-00000", "Jason format error, program is going to exit"),
    VALUES_MORE_THAN_ONE("JSON2SOQL-00001", "Values more than one, program is going to exit"),
    OPERATION_NOT_SUPPORTED("JSON2SOQL-00002", "Operation was not supported, program is going to exit"),
    JASON_MAPPING_EXCEPTION("JSON2SOQL-00003", "this is a JsonMappingException when read value from json, program is going to exit"),
    JASON_PROCESS_EXCEPTION("JSON2SOQL-00004", "this is a JsonProcessException when read value from json, program is going to exit"),
    IO_EXCEPTION("JSON2SOQL-00005", "IO exception, program is going to exit"),
    NO_VALULE("JSON2SOQL-00006", "No Value, program is going to exit");

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    private String reason;

    ErrorCodeEnums(String code, String reason) {
        this.code = code;
        this.reason = reason;
    }
}
