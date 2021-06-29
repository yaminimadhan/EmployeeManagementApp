package org.nagarro.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.*;



@Service
public class EmployeeService {
	
	private static final String GET_EMPLOYEES_ENDPOINT_URL = "http://localhost:9090/employee";
	private static final String GET_EMPLOYEE_ENDPOINT_URL = "http://localhost:9090/employee/{id}";
    private static final String CREATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:9090/employee";
    private static final String UPDATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:9090/employee/{id}";
    private static final String DELETE_EMPLOYEE_ENDPOINT_URL = "http://localhost:9090/employee/{id}";
	
	private static RestTemplate restTemplate = new RestTemplate();
	
	public ArrayList<Employee> getEmployees() throws JsonMappingException, JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity < String > entity = new HttpEntity < String > ("parameters", headers);
        
        ResponseEntity<String> responseEntity = restTemplate.exchange(GET_EMPLOYEES_ENDPOINT_URL, HttpMethod.GET,entity,String.class);
		String emp = responseEntity.getBody();
		//List<Employee> employees = Arrays.asList(emp);
        ResponseEntity <String> result = restTemplate.exchange(GET_EMPLOYEES_ENDPOINT_URL, HttpMethod.GET, entity, String.class);
        String employeeList= result.getBody();
        
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<ArrayList<Employee>> mapType = new TypeReference<ArrayList<Employee>>() {};
        ArrayList<Employee> jsonToList = objectMapper.readValue(employeeList, mapType);
        return jsonToList;
    }
	
	public void createEmployee(Employee newEmployee) {
        RestTemplate restTemplate = new RestTemplate();
        Employee result = restTemplate.postForObject(CREATE_EMPLOYEE_ENDPOINT_URL, newEmployee, Employee.class);
        System.out.println(result);
    }
	
	public Employee getEmployeeById(Long ecode) {
        Map < String, Long > params = new HashMap < String, Long > ();
        params.put("id", ecode);
        RestTemplate restTemplate = new RestTemplate();
        Employee result = restTemplate.getForObject(GET_EMPLOYEE_ENDPOINT_URL, Employee.class, params);
        return result;
    }
	
	 public void updateEmployee(Long ecode, String ename, String location, String email, Date dob) {
	        Map < String, Long > params = new HashMap < String, Long > ();
	        params.put("id", ecode);
	        Employee updatedEmployee = new Employee(ename, location, email, dob);
	        RestTemplate restTemplate = new RestTemplate();
	        restTemplate.put(UPDATE_EMPLOYEE_ENDPOINT_URL, updatedEmployee, params);
	    }
	 
	 public void deleteEmployee(Long ecode) {
	        Map < String, Long > params = new HashMap < String, Long > ();
	        params.put("id", ecode);
	        RestTemplate restTemplate = new RestTemplate();
	        restTemplate.delete(DELETE_EMPLOYEE_ENDPOINT_URL, params);
	    
	 }
}