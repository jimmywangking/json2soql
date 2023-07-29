package com.aaron.json2soql.object;

/**
 * {
 *   "conditions": [
 *     {
 *       "field": <String>,
 *       "operator": <String>,
 *       "values": [<String>]
 *     },
 *     ...
 *   ],
 *   "conjunction": <String>
 * }
 */
public class JsonObject {
    String conjunction;

    Condition[] conditions;

    public String getConjunction() {
        return conjunction;
    }

    public Condition[] getConditions() {
        return conditions;
    }

    public void setConjunction(String conjunction) {
        this.conjunction = conjunction;
    }


}
