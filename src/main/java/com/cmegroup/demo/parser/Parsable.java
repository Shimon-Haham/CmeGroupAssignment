package com.cmegroup.demo.parser;

import java.util.List;

import com.cmegroup.demo.model.ParsingResult;

public interface Parsable {

	List<ParsingResult> getParsedData();
}
