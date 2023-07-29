package com.aaron.json2soql.services;

import com.aaron.json2soql.constants.Conjunction;
import com.aaron.json2soql.databind.JsonObjectMapper;
import com.aaron.json2soql.enums.ErrorCodeEnums;
import com.aaron.json2soql.exception.SoqlException;
import com.aaron.json2soql.object.Condition;
import com.aaron.json2soql.object.JsonObject;
import com.aaron.json2soql.translator.ConJunctionTranslator;
import com.aaron.json2soql.translator.OperationTranslator;
import com.aaron.json2soql.validation.ConditionValidation;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class Json2SoqlService {
    public String normalJson2Soql(String originJson){
        StringBuilder result = new StringBuilder();

//        1. Json to Obeject
        JsonObjectMapper jsonObjectMapper = new JsonObjectMapper();
        JsonObject jsonObject = jsonObjectMapper.translateJson(originJson);

//        2. Object to Sqal
        for (int i = 0; i < jsonObject.getConditions().length; i++) {
            Condition condition = jsonObject.getConditions()[i];

//              3.Operation Validation
            ConditionValidation conditionValidation = new ConditionValidation();
            conditionValidation.OperationValidation(condition.getOperator());

//              4. Values validation
            conditionValidation.ValuesValidation(condition.getValues());

//              5.Operation translation
            OperationTranslator operationTranslator = new OperationTranslator();
            condition = operationTranslator.TranslateOperation(condition);

//              6. Condition construction
            ConditionConstruct conditionConstruct = new ConditionConstruct();
            result.append("("+conditionConstruct.ToCondition(condition)+")");

//              7.Conjunction
            String conJunction = jsonObject.getConjunction();
            if(i!=jsonObject.getConditions().length-1){
                if(conJunction.trim().equalsIgnoreCase((Conjunction.AND).trim())){
                    result.append(Conjunction.AND);
                }else{
                    result.append(Conjunction.OR);
                }
            }
        }
        System.out.println("normalJson2Soql: "+result.toString());
        return result.toString();
    }

    public String recursiveJson2Soql(JSONObject jsonObject) {
        StringBuilder result = new StringBuilder();
        if (!jsonObject.has("conditions")) {
            return "";
        }
        JSONArray conditionsArray = jsonObject.getJSONArray("conditions");
        for (int i = 0; i < conditionsArray.length(); i++) {
            JSONObject conditionObject = conditionsArray.getJSONObject(i);
            ConJunctionTranslator conJunctionTranslator = new ConJunctionTranslator();
            if (conditionObject.has("field") && conditionObject.has("operator") && conditionObject.has("values")) {
//                  1. Get field, operator, values
                String field = conditionObject.getString("field");
                String operator = conditionObject.getString("operator");
                JSONArray valuesArray = conditionObject.getJSONArray("values");
//                   2. Values should have one value
                if (valuesArray.length() != 1) {
                    throw new SoqlException(ErrorCodeEnums.NO_VALULE);
                }
//                  3. construct condition
                String value = valuesArray.getString(0);
                Condition condition = new Condition(field,operator, new String[]{value});
//                  4.operation validation
                ConditionValidation conditionValidation = new ConditionValidation();
                conditionValidation.OperationValidation(operator);

//                  5.Operation translation
                OperationTranslator operationTranslator = new OperationTranslator();
                condition = operationTranslator.TranslateOperation(condition);

//                  6. Condition construction
                ConditionConstruct conditionConstruct = new ConditionConstruct();
                result.append("("+conditionConstruct.ToCondition(condition)+")");

//              7.Conjunction
                String conJunction = jsonObject.getString("conjunction");
                if(i!=conditionsArray.length()-1){
                    result.append(conJunctionTranslator.TranslateConJunction(conJunction));
                }
            } else if (conditionObject.has("conditions")) {
//                System.out.println("conditionObject: "+i+"=============="+conditionObject.toString());
                String nestedSoql = recursiveJson2Soql(conditionObject);
                if(i!=conditionsArray.length()-1){
                    result.append("(").append(nestedSoql).append(")").append(conJunctionTranslator.TranslateConJunction(conditionObject.getString("conjunction")));
                }else{
                    result.append(nestedSoql);
                }
            }
        }

        System.out.println("recursiveJson2Soql: " + result.toString());
        return result.toString();
    }
}
