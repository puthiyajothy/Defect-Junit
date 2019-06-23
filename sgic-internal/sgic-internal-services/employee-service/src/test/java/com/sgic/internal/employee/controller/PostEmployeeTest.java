package com.sgic.internal.employee.controller;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;
import com.sgic.internal.employee.EmployeeTest;
import com.sgic.internal.employee.dto.EmployeeDTO;

public class PostEmployeeTest extends EmployeeTest {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unused")
	private EmployeeDTO employeeDTO = new EmployeeDTO();
	private String BASE_URL = "http://localhost:8080/employeeservice";
	private String ADD_API_URL = "/createemployee";
//	private String GET_API_URL = "/getallemployee";

	@SuppressWarnings("unused")
	private static final String ADD_EMPLOYEE_RESPONSE = "[{\"empId\":\"emp00\",\"name\":\"jothi\",\"email\":\"saidputhi@gmail.com\",\"designation\":\"QA\"}]";
//	private static final String GET_EMPLOYEE_RESPONSE = "{\"empId\":\"emp001\",\"name\":\"jothi\",\"email\":\"saidputhi@gmail.com\",\"designation\":\"QA\"}";

	@Test
	public void addEmployee() throws IOException, RestClientException {
//	EmployeeDTO.setMainClassName("ABC");
		EmployeeDTO employeeDTO = new EmployeeDTO("emp001", "jothi", "saidputhi@gmail.com", "QA");
		HttpEntity<EmployeeDTO> request = new HttpEntity<EmployeeDTO>(employeeDTO, httpHeaders);
		ResponseEntity<String> postResponse = testRestTemplate.postForEntity(BASE_URL + ADD_API_URL, request,
				String.class);
		assertEquals(200, postResponse.getStatusCodeValue());
	}

}
