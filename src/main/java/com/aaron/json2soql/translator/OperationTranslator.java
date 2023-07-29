package com.aaron.json2soql.translator;

import com.aaron.json2soql.constants.Operations;
import com.aaron.json2soql.object.Condition;

public class OperationTranslator {

    /**
     * "equals",
     * "notEquals",
     * "lessThan",
     * "lessThanOrEqualTo",
     * "greaterThan",
     * "greaterThanOrEqualTo",
     */
    public Condition TranslateOperation(Condition condition){
        if(condition.getOperator().equalsIgnoreCase(Operations.EQUALS)){
            condition.setOperator(Operations.SOQL_EQUALS);
        } else if (condition.getOperator().equalsIgnoreCase(Operations.NOTEQUALS)) {
            condition.setOperator(Operations.SOQL_NOTEQUALS);
        } else if (condition.getOperator().equalsIgnoreCase(Operations.LESSTHAN)) {
            condition.setOperator(Operations.SOQL_LESSTHAN);
        } else if (condition.getOperator().equalsIgnoreCase(Operations.LESSTHANOREQUALTO)) {
            condition.setOperator(Operations.SOQL_LESSTHANOREQUALTO);
        } else if (condition.getOperator().equalsIgnoreCase(Operations.GREATERTHAN)) {
            condition.setOperator(Operations.SOQL_GREATERTHAN);
        } else if (condition.getOperator().equalsIgnoreCase(Operations.GREATERTHANOREQUALTO)) {
            condition.setOperator(Operations.SOQL_GREATERTHANOREQUALTO);
        }
        return condition;
    }
    public String TranslateOperationByOperation(String operator){
        if(operator.equalsIgnoreCase(Operations.EQUALS)){
            operator = Operations.SOQL_EQUALS;
        } else if (operator.equalsIgnoreCase(Operations.NOTEQUALS)) {
            operator = Operations.SOQL_NOTEQUALS;
        } else if (operator.equalsIgnoreCase(Operations.LESSTHAN)) {
            operator = Operations.SOQL_LESSTHAN;
        } else if (operator.equalsIgnoreCase(Operations.LESSTHANOREQUALTO)) {
            operator = Operations.SOQL_LESSTHANOREQUALTO;
        } else if (operator.equalsIgnoreCase(Operations.GREATERTHAN)) {
            operator = Operations.SOQL_GREATERTHAN;
        } else if (operator.equalsIgnoreCase(Operations.GREATERTHANOREQUALTO)) {
            operator = Operations.SOQL_GREATERTHANOREQUALTO;
        }
        return operator;
    }
}
