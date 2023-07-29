package com.aaron.json2soql.translator;

import com.aaron.json2soql.constants.Conjunction;

public class ConJunctionTranslator {
    public String TranslateConJunction(String originConJunction){
        if(originConJunction.trim().equalsIgnoreCase((Conjunction.AND).trim())){
            return Conjunction.AND;
        }else{
            return  Conjunction.OR;
        }
    }
}
