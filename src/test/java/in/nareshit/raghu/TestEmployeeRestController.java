package in.nareshit.raghu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class TestEmployeeRestController {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testSaveEmployee() throws Exception {
		//1. create Dummy Request
		MockHttpServletRequestBuilder request =
				MockMvcRequestBuilders
				.post("/employee/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"empName\":\"JAI\",\"empSal\":6500.0}");

		//2. execute request and get result
		MvcResult result = mockMvc.perform(request).andReturn();

		//3. Read Response
		MockHttpServletResponse response = result.getResponse();

		//4. Test using assert Method
		//is status code is -200
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		if(!response.getContentAsString().contains("Employee saved")) {
			fail("SAVE EMPLOYEE NOT WORKING!! ");
		}

	}


	@Test
	public void testGetAllEmployee() throws Exception {
		//1. create Dummy Request
		MockHttpServletRequestBuilder request = 
				MockMvcRequestBuilders.get("/employee/all");

		//2. execute request and get result
		MvcResult result = mockMvc.perform(request).andReturn();

		//3. Read Response
		MockHttpServletResponse response = result.getResponse();

		//4. Test using assert Method
		//is status code is -200
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
		if(response.getContentAsString().length()<=0) {
			fail("No Data Found");
		}

	}

	@Test
	public void testGetOneEmployeeExist() throws Exception {
		//1. create Dummy Request
		MockHttpServletRequestBuilder request =
				MockMvcRequestBuilders.get("/employee/one/3");
		
		//2. execute request and get result
		MvcResult result = mockMvc.perform(request).andReturn();

		//3. Read Response
		MockHttpServletResponse response = result.getResponse();
		
		//4. Test using assert Method
		//is status code is -200
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
		if(response.getContentAsString().isEmpty()) {
			fail("Employee data not provided");
		}
		
	}

	@Test
	public void testGetOneEmployeeNotExist() throws Exception {
		//1. create Dummy Request
		MockHttpServletRequestBuilder request =
				MockMvcRequestBuilders.get("/employee/one/30");

		//2. execute request and get result
		MvcResult result = mockMvc.perform(request).andReturn();
		
		//3. Read Response
		MockHttpServletResponse response = result.getResponse();
		
		//4. Test using assert Method
		//is status code is -404
		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
		if(!response.getContentAsString().equals("Employee not exist")) {
			fail(" May be data exist, please check again");
		}
	}


}
