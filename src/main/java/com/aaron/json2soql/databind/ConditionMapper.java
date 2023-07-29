package com.aaron.json2soql.databind;
import com.aaron.json2soql.enums.ErrorCodeEnums;
import com.aaron.json2soql.exception.SoqlException;
import com.aaron.json2soql.object.Condition;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/*
{
      "field" : "Country_vod__c",
      "operator" : "notLike",
      "values" : [ "'%a%'" ]
    }
 */
public class ConditionMapper {
    ObjectMapper objectMapper = new ObjectMapper();


    public void ConditionMapper(String originJson)  {
        try{
//            // 1.字符串转为字节数组
//            byte[] byteArray = originJson.getBytes(StandardCharsets.UTF_8);
//
//            // 2.构造字节数组输入流
//            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
//
//            // 3.构造输入流读取器
//            InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream); //, StandardCharsets.UTF_8);
//
//            // 4.构造缓冲型读取器
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//            String line;
//            StringBuilder stringBuilder = new StringBuilder();
//            // 5.循环读取每行字符串，并做必要处理
//            while ((line = bufferedReader.readLine()) != null) {
//                // 去掉每行两端的空格，并重新拼接为一行
//                stringBuilder.append(line.trim());
//            }
//
//            // 6.结果输出
//            System.err.println(stringBuilder);
//            System.out.println(stringBuilder.toString());
//
//            Condition condition = objectMapper.readValue(stringBuilder.toString(), Condition.class);
            Condition condition = objectMapper.readValue(originJson, Condition.class);
            System.out.println("operation: "+condition.field+" "+condition.operator+" "+condition.values[0]);
        }catch (JsonMappingException e) {
            throw new SoqlException(ErrorCodeEnums.JASON_MAPPING_EXCEPTION);
        } catch (JsonProcessingException e) {
            throw new SoqlException(ErrorCodeEnums.JASON_PROCESS_EXCEPTION);
        } catch (IOException e) {
            throw new SoqlException(ErrorCodeEnums.IO_EXCEPTION);
        }
    }


    public static void main(String[] args) {
        ConditionMapper conditionMapper = new ConditionMapper();
        String originJson = "{\n" +
                "      \"field\" : \"Country_vod__c\",\n" +
                "      \"operator\" : \"notLike\",\n" +
                "      \"values\" : [ \"'%a%'\" ]\n" +
                "    }";
        conditionMapper.ConditionMapper(originJson);
    }
}
