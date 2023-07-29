package com.aaron.json2soql.services;


import org.json.JSONObject;

public class Json2SoqlServiceTest {

    public String TestNormalJson2Soal() {
        String originJson = "{\n" +
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


        Json2SoqlService json2SoqlService = new Json2SoqlService();
        return json2SoqlService.normalJson2Soql(originJson);

    }

    public String TestRecursiveJson2Soql(){
        String originJson = "{\n" +
                "  \"conditions\" : [\n" +
                "    {\n" +
                "      \"conditions\" : [\n" +
                "        {\n" +
                "          \"conditions\" : [\n" +
                "            {\n" +
                "              \"conditions\" : [\n" +
                "                {\n" +
                "                  \"field\" : \"Country_vod__c\",\n" +
                "                  \"operator\" : \"like\",\n" +
                "                  \"values\" : [ \"'%a%'\" ]\n" +
                "                },\n" +
                "                {\n" +
                "                  \"field\" : \"Email_vod__c\",\n" +
                "                  \"operator\" : \"notLike\",\n" +
                "                  \"values\" : [ \"'%b%'\" ]\n" +
                "                }\n" +
                "              ],\n" +
                "              \"conjunction\" : \"and\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"conditions\" : [\n" +
                "                {\n" +
                "                  \"field\" : \"City_vod__c\",\n" +
                "                  \"operator\" : \"equals\",\n" +
                "                  \"values\" : [ \"'c'\" ]\n" +
                "                },\n" +
                "                {\n" +
                "                  \"field\" : \"Name\",\n" +
                "                  \"operator\" : \"notEquals\",\n" +
                "                  \"values\" : [ \"'d'\" ]\n" +
                "                }\n" +
                "              ],\n" +
                "              \"conjunction\" : \"and\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"conjunction\" : \"or\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"field\" : \"Address_Line_1_vod__c\",\n" +
                "          \"operator\" : \"lessThan\",\n" +
                "          \"values\" : [ \"'e'\" ]\n" +
                "        }\n" +
                "      ],\n" +
                "      \"conjunction\" : \"and\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"conditions\" : [\n" +
                "        {\n" +
                "          \"field\" : \"Address_Line_1_vod__c\",\n" +
                "          \"operator\" : \"greaterThan\",\n" +
                "          \"values\" : [ \"'f'\" ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"field\" : \"Address_Line_2_vod__c\",\n" +
                "          \"operator\" : \"lessThanOrEqualTo\",\n" +
                "          \"values\" : [ \"'g'\" ]\n" +
                "        }\n" +
                "      ],\n" +
                "      \"conjunction\" : \"and\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"conditions\" : [\n" +
                "        {\n" +
                "          \"field\" : \"Call2_vod__r.Name\",\n" +
                "          \"operator\" : \"greaterThanOrEqualTo\",\n" +
                "          \"values\" : [ \"'h'\" ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"field\" : \"City_vod__c\",\n" +
                "          \"operator\" : \"like\",\n" +
                "          \"values\" : [ \"'i%'\" ]\n" +
                "        }\n" +
                "      ],\n" +
                "      \"conjunction\" : \"and\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"conjunction\" : \"or\"\n" +
                "}";

//        String originJson = "{\n" +
//                "  \"conditions\" : [\n" +
//                "    {\n" +
//                "      \"field\" : \"Country_vod__c\",\n" +
//                "      \"operator\" : \"notLike\",\n" +
//                "      \"values\" : [ \"'%a%'\" ]\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"field\" : \"Account_vod__r.Name\",\n" +
//                "      \"operator\" : \"like\",\n" +
//                "      \"values\" : [ \"'%b%'\" ]\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"field\" : \"QA_Field_04__c\",\n" +
//                "      \"operator\" : \"greaterThanOrEqualTo\",\n" +
//                "      \"values\" : [ \"2020-09-18T16:00:00.000Z\" ]\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"field\" : \"QA_Field_02__c\",\n" +
//                "      \"operator\" : \"equals\",\n" +
//                "      \"values\" : [ \"CNY1\" ]\n" +
//                "    }\n" +
//                "  ],\n" +
//                "  \"conjunction\" : \"and\"\n" +
//                "}";

        Json2SoqlService json2SoqlService = new Json2SoqlService();
        JSONObject jsonObject = new JSONObject(originJson);
        String result = json2SoqlService.recursiveJson2Soql(jsonObject);
        return result;
    }
    public static void main(String[] args) {
        Json2SoqlServiceTest json2SoqlServiceTest = new Json2SoqlServiceTest();
        json2SoqlServiceTest.TestNormalJson2Soal();
        json2SoqlServiceTest.TestRecursiveJson2Soql();
    }
}
