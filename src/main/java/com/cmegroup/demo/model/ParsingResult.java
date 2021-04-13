package com.cmegroup.demo.model;

import org.json.JSONObject;

public final class ParsingResult {

    private final String data;
    private final boolean isValid;

    public ParsingResult() {
        this.data = analyzeResult(false, "", "EMpty Object");
        this.isValid = false;
    }
    
    public ParsingResult(boolean isValid, String data, String errorMessage) {
        this.data = analyzeResult(isValid, data, errorMessage);
        this.isValid = isValid;
    }

    private String analyzeResult(boolean isValid, String data, String errorMessage) {
    	if(isValid) {
    		return data;
    	}else {
    		return new JSONObject()
                    .put("originalMessage", data)
                    .put("error", errorMessage)
                    .toString();
    	}
    }
    public String getData() {
        return this.data;
    }
    

    public boolean isValid() {
        return this.isValid;
    }
}
