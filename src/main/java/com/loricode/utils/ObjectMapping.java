package com.loricode.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loricode.dtos.CompanyUserDto;

public class ObjectMapping{
	
	public static Object dataTransform(String json) {

		ObjectMapper objectMapper = new ObjectMapper();
		Object data = null;
		
		try {
			
		 data = objectMapper.readValue(json, CompanyUserDto.class);
	
		return data;
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
}
