package com.aaron.json2soql.object;

/**
 *
 "field": <String>,
 "operator": <String>,
 "values": [<String>]
 */

public class Condition {
    public String getField() {
        return field;
    }

    public String getOperator() {
        return operator;
    }

    public String[] getValues() {
        return values;
    }

    public String field;

    public void setField(String field) {
        this.field = field;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    public String operator;
    public String[] values;

    public Condition(String field, String operator, String[] values) {
        this.field = field;
        this.operator = operator;
        this.values = values;
    }

    public Condition() {
    }
}
