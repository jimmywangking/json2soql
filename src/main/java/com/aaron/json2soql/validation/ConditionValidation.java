package com.aaron.json2soql.validation;

import com.aaron.json2soql.constants.Operations;
import com.aaron.json2soql.enums.ErrorCodeEnums;
import com.aaron.json2soql.exception.SoqlException;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * If the operator attribute is "like", "notLike", "equals", "notEquals", "lessThan", "lessThanOrEqualTo", "greaterThan", or "greaterThanOrEqualTo", then the corresponding SOQL operator should be used in the output. If the operator attribute is not one of the supported operators, then the program should exit with an error message.
 */
public class ConditionValidation {
     public static String[] operations = {Operations.LIKE,
             Operations.NOTLIKE.toLowerCase(),
             Operations.EQUALS,
             Operations.NOTEQUALS.toLowerCase(),
             Operations.LESSTHAN.toLowerCase(),
             Operations.LESSTHANOREQUALTO.toLowerCase(),
             Operations.GREATERTHAN.toLowerCase(),
             Operations.GREATERTHANOREQUALTO.toLowerCase()
     };

     public void OperationValidation(String operation){
          if(!Arrays.asList(this.operations).contains(operation.toLowerCase())){
               throw new SoqlException(ErrorCodeEnums.OPERATION_NOT_SUPPORTED);
          }
     }

     public void ValuesValidation(String[] values){
          if(values.length>1){
               throw new SoqlException(ErrorCodeEnums.VALUES_MORE_THAN_ONE);
          }
     }
}
