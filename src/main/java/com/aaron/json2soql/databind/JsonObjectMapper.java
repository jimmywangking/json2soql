package com.aaron.json2soql.databind;

import com.aaron.json2soql.enums.ErrorCodeEnums;
import com.aaron.json2soql.exception.SoqlException;
import com.aaron.json2soql.object.JsonObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * {
 *   "conditions" : [
 *     {
 *       "field" : "Country_vod__c",
 *       "operator" : "notLike",
 *       "values" : [ "'%a%'" ]
 *     },
 *     {
 *       "field" : "Account_vod__r.Name",
 *       "operator" : "like",
 *       "values" : [ "'%b%'" ]
 *     },
 *     {
 *       "field" : "QA_Field_04__c",
 *       "operator" : "greaterThanOrEqualTo",
 *       "values" : [ "2020-09-18T16:00:00.000Z" ]
 *     },
 *     {
 *       "field" : "QA_Field_02__c",
 *       "operator" : "equals",
 *       "values" : [ "CNY1" ]
 *     }
 *   ],
 *   "conjunction" : "and"
 * }
 */
public class JsonObjectMapper {
    ObjectMapper objectMapper = new ObjectMapper();
    String originJson;

    public JsonObject translateJson(String originJson) {
        this.originJson = originJson;
        try {
            JsonObject jsonObject = objectMapper.readValue(originJson, JsonObject.class);
            return jsonObject;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new SoqlException(ErrorCodeEnums.JASON_FORMAT_ERROR);
        }
    }

    public static void main(String[] args) {
        String testJson = "{\n" +
                "  \"conditions\" : [\n" +
                "    {\n" +
                "      \"field\" : \"Country_vod__c\",\n" +
                "      \"operator\" : \"notLike\",\n" +
                "      \"values\" : [ \"'%a%'\" ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"field\" : \"Account_vod__r.Name\",\n" +
                "      \"operator\" : \"like\",\n" +
                "      \"values\" : [ \"'%b%'\" ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"field\" : \"QA_Field_04__c\",\n" +
                "      \"operator\" : \"greaterThanOrEqualTo\",\n" +
                "      \"values\" : [ \"2020-09-18T16:00:00.000Z\" ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"field\" : \"QA_Field_02__c\",\n" +
                "      \"operator\" : \"equals\",\n" +
                "      \"values\" : [ \"CNY1\" ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"conjunction\" : \"and\"\n" +
                "}";
        JsonObjectMapper jsonObjectMapper = new JsonObjectMapper();
        jsonObjectMapper.translateJson(testJson);

    }
}
