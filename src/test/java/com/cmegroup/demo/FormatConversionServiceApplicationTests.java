package com.cmegroup.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.cmegroup.demo.constants.ConstantMessages;
import com.cmegroup.demo.model.ParsingResult;
import com.cmegroup.demo.parser.Csv2Json;
import com.cmegroup.demo.parser.Xml2Json;



class FormatConversionServiceApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(FormatConversionServiceApplicationTests.class);
	
	@Test
	void contextLoads() {

	}
	
	@Test
	void ValidateCsvParser() {

		Csv2Json parsedMessages = new Csv2Json(ConstantMessages.CSV_TEST_MESSAGE);
		List<ParsingResult> messageList  = parsedMessages.getParsedData();
		
		assumeTrue(messageList.get(0).getData().equals(ConstantMessages.CSV_TO_JSON_EXPECTED_MESSAGE_0), "Conversion of message one failed ");
		assumeTrue(messageList.get(1).getData().equals(ConstantMessages.CSV_TO_JSON_EXPECTED_MESSAGE_1), "Conversion of message two failed ");
	}
	
	@Test
	void ValidateXmlParser() {

		Xml2Json parsedMessages = new Xml2Json(ConstantMessages.XML_TEST_MESSAGE);
		List<ParsingResult> messageList  = parsedMessages.getParsedData();
		
		assertEquals(messageList.get(0).getData(), ConstantMessages.XML_TO_JSON_EXPECTED_MESSAGE);
		
	}
		
}
