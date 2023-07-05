package com.example.crud.controller;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.crud.service.CrudServiceTddService;




@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class CrudServiceTddControllerTest {

	
	private MockMvc mockMvc;

	@Mock
	private MockMvcRequestBuilders mockMvcBuilder;

	@InjectMocks
	private CrudServiceTddController controller;

	
	@Mock
	private CrudServiceTddService service;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
	}
	
	
	@Test
	public void testGivenfromUnitAndtoUnitAsKey_whenBothInputsAreDifferent_thenWeWillGetFormulaFromCrudService() {

		String convertedUnitKey ="METER-KM";
      when(service.findByKey(convertedUnitKey)).thenReturn("/1000");

		ResponseEntity<String> response = controller.getFormula("METER", "KM");

		System.out.println("FORMULA:"+response.getBody());
		Assert.assertEquals("/1000", response.getBody());

	}

	@Test()
	public void getFormulaFailureScenario() throws Exception {

		String convertedUnit = "km-meter";

		String uri = "/getConvertedUnit/{convertedUnit}";
		when(service.findByKey(convertedUnit)).thenReturn("*1000");

		MvcResult mvcResult = (MvcResult) mockMvc.perform(MockMvcRequestBuilders.get(uri, "km-meter"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("*1000")).andReturn();

		
		Assert.assertEquals("/1000", mvcResult.getResponse().getContentAsString());

	}

	@Test
	public void getFormulaSuccessScenario() throws Exception {

		String convertedUnit = "km-meter";
		String uri = "/getConvertedUnit/{convertedUnit}";

		when(service.findByKey(convertedUnit)).thenReturn("*1000");

		MvcResult mvcResult = (MvcResult) mockMvc.perform(MockMvcRequestBuilders.get(uri, "km-meter"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("*1000")).andReturn();

		Assert.assertEquals("*1000", mvcResult.getResponse().getContentAsString());

	}

}
