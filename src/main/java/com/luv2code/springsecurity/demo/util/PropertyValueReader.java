package com.luv2code.springsecurity.demo.util;

import org.springframework.core.env.Environment;

public class PropertyValueReader {

	
	
	
	public static int getIntProperty(String propName, Environment env) {
		
		String propVal = env.getProperty(propName);
		
		int intProp = Integer.parseInt(propVal);
		
		return intProp;
	}
}
