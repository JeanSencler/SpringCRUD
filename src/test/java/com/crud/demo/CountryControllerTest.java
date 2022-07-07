package com.crud.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.crud.demo.model.Country;

@SpringBootTest
 class CountryControllerTest extends AbstractTest{

	
	@Test
	 void getLocalCountryList() throws Exception {
	   String uri = "/countries";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   Country[] countryList = super.mapFromJson(content, Country[].class);
	   assertTrue(countryList.length > 0);
	}
	
	@Test
	 void createProduct() throws Exception {
	   String uri = "/countries";
	   Country country = new Country();
	   country.setCountryId(3);
	   country.setCountryName("TestCountry");
	   
	   String inputJson = super.mapToJson(country);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   assertEquals("Country is created successfully", content);
	}
}
