package com.crud.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.crud.demo.model.Country;
import com.crud.demo.service.CountryServiceImpl;

 class CountryControllerTest extends AbstractTest{
	
	 
	 @Autowired
		private CountryServiceImpl underTest;
	 
	 @Test
	 void debeListarPaises() throws Exception {
		List<Country> list = underTest.getAll();
		 assertEquals(false, list.isEmpty());
	}
	 
	 @Test
	 void debeObtenerPaisPorID() throws Exception {
		 Country country = underTest.getById((long) 1);
		 assertEquals("Pais Generico 1", country.getCountryName());
	}
	 
	 @Test
	 void debeCrearPaisLocal() throws Exception {
		 Country country = new Country();
		 country.setCountryId(3);
		 country.setCountryName("Pais Generico 3");
		 country.setState('S');
		 underTest.create(country);
		 Country createdCountry = underTest.getById((long) 3);
		 assertEquals("Pais Generico 3", createdCountry.getCountryName());
	}
	 
	 /*
	@Test
	 void debeListarPaisesExternosAPI() throws Exception {
	   String uri = "/countries/external";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   Object[] countryList = super.mapFromJson(content, Object[].class);
	   assertTrue(countryList.length > 0);
	}*/
}
