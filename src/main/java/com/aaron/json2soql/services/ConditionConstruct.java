package com.aaron.json2soql.services;

import com.aaron.json2soql.constants.Operations;
import com.aaron.json2soql.object.Condition;

public class ConditionConstruct {
    String ToCondition (Condition condition){
        StringBuilder result = new StringBuilder();
        if(condition.getOperator().equalsIgnoreCase(Operations.NOTLIKE)){
            result = result.append(Operations.NOTLIKE).insert(3, " "+condition.getField()+" ").append(" "+condition.getValues()[0]);
        }else{
            result = result.append(condition.getField()).append(" "+condition.getOperator()+" ").append(condition.getValues()[0]);
        }
        return result.toString();
    }
}
