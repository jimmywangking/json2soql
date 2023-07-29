package com.aaron.json2soql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The input JSON has the following structure:
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
 * The output SOQL should have the following structure:
 * (<field> <operator> <value>) <conjunction> (<field> <operator> <value>) <conjunction> ...
 * Where <field> is the field attribute from the input JSON, <operator> is the operator attribute from the input JSON, <value> is the first element from the values array in the input JSON, and <conjunction> is either "AND" or "OR" depending on the conjunction attribute in the input JSON.
 * If the operator attribute is "like", "notLike", "equals", "notEquals", "lessThan", "lessThanOrEqualTo", "greaterThan", or "greaterThanOrEqualTo", then the corresponding SOQL operator should be used in the output.
 * If the operator attribute is not one of the supported operators, then the program should exit with an error message.
 * If a values array has more than one element, then the program should exit with an error message.
 * If the input JSON has nested conditions, then the program should recursively process them as well.
 */
@SpringBootApplication
public class Json2soqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Json2soqlApplication.class, args);
    }

}
