package com.cmegroup.demo.constants;

public class ConstantMessages {

	public static final String XML_TEST_MESSAGE = "<customer><streetName>Treutel Causeway</streetName><number>5027</number><city>North Palmaburgh</city><country>Latvia</country></customer>";
	public static final String XML_TO_JSON_EXPECTED_MESSAGE = "{\"customer\":{\"number\":5027,\"country\":\"Latvia\",\"streetName\":\"Treutel Causeway\",\"city\":\"North Palmaburgh\"}}";

	public static final String CSV_TEST_MESSAGE = "year,industry_code_ANZSIC,industry_name_ANZSIC,rme_size_grp,variable,value\n" + 
			                                      "2011,A,\"Agriculture, Forestry and Fishing\",a_0,Activity unit,46134\n" + 
			                                      "2011,A,\"Agriculture, Forestry and Fishing\",a_1,Rolling mean employees,0\n";
	public static final String CSV_TO_JSON_EXPECTED_MESSAGE_0 = "{\"industry_code_ANZSIC\":\"A\",\"year\":\"2011\",\"rme_size_grp\":\"a_0\",\"variable\":\"Activity unit\",\"industry_name_ANZSIC\":\"Agriculture, Forestry and Fishing\",\"value\":\"46134\"}";
	public static final String CSV_TO_JSON_EXPECTED_MESSAGE_1 = "{\"industry_code_ANZSIC\":\"A\",\"year\":\"2011\",\"rme_size_grp\":\"a_1\",\"variable\":\"Rolling mean employees\",\"industry_name_ANZSIC\":\"Agriculture, Forestry and Fishing\",\"value\":\"0\"}";

}
