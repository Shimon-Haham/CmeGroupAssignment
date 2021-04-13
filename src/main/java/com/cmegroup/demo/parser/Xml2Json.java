package com.cmegroup.demo.parser;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmegroup.demo.model.ParsingResult;

public final class Xml2Json implements Parsable {
	
    int PRETTY_PRINT_INDENT_FACTOR = 4;
	private final ParsingResult result;
    private String originalMessage = "";
    
    private static final Logger logger = LoggerFactory.getLogger(Xml2Json.class);
    
    
	public Xml2Json(String  message) {
		this.originalMessage = message;
		this.result = this.parseXml();
	}
	
	public ParsingResult parseXml() {
		ParsingResult result = new ParsingResult();
		logger.info("Parsing in progress ...");
        try {
            JSONObject xmlJSONObj = XML.toJSONObject(this.originalMessage);
            if(xmlJSONObj.isEmpty()) {
            	result = new ParsingResult(false, this.originalMessage, "Failed to convert xml to json incorrect type");
            }else {            	
            	result = new ParsingResult(true, xmlJSONObj.toString(), "success");
            }
        } catch (Exception e) {
        	result = new ParsingResult(false, this.originalMessage, "Failed to convert xml to json");
        }
        return result;
	}

	@Override
	public List<ParsingResult> getParsedData() {
		return List.of(result);
	}
}
