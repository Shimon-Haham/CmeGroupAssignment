package com.cmegroup.demo.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.CDL;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmegroup.demo.model.ParsingResult;

public final class Csv2Json implements Parsable {

	private final List<ParsingResult> result;

	private static final Logger logger = LoggerFactory.getLogger(Csv2Json.class);
	
	public Csv2Json(String message){
		this.result = parseCsv(message);
	}
	
	public List<ParsingResult> parseCsv(String message) {
		
		List<ParsingResult> parsedData = new ArrayList<ParsingResult>();

		logger.info("Parsing in progress ...");
		try {
			JSONArray jsonMessages = CDL.toJSONArray(message);
			if(jsonMessages == null) {
			    parsedData.add(
			    		new ParsingResult(
			    				false, message,"Unable to parse the CSV message-- inccorect format"));
			}

			for(int i=0 ;i<jsonMessages.length(); i++) {
			    parsedData.add(
			    		new ParsingResult(
			    				true, jsonMessages.getJSONObject(i).toString(),"succsess"));
			}
		} catch (Exception e) {
		    parsedData.add(
		    		new ParsingResult(
		    				false, message,String.format("Exeption thrown during message parsing [%s] ",e.getMessage())));
		}
		return parsedData;
	}

	@Override
	public List<ParsingResult> getParsedData() {
		return result;
	}
}
