package org.nagarro.employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class EmployeeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/")
	public ModelAndView home() {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("message", "Hello!");
	    return mav;
	}
	
	@RequestMapping("/getEmployees")
	public ModelAndView home(@RequestParam String username, String password) throws JsonMappingException, JsonProcessingException {
		User foundUser = userService.findByUsername(username);
		if(foundUser.getPassword().equals(password)) {
			ArrayList<Employee> employeeList = employeeService.getEmployees();
			ModelAndView mav = new ModelAndView("employeeDetails");
			mav.addObject("employeeList", employeeList);
			mav.addObject("user",username);
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("Forbidden");
			mav.addObject("message", "Invalid Username or password");
			return mav;
		}
		
	}
	
	@RequestMapping("/addEmployeeForm")
	public ModelAndView Form() {
		ModelAndView mav = new ModelAndView("NewEmployee");
		return mav;
	}
	
	@RequestMapping("/addEmployee")
	public ModelAndView Add(@RequestParam String name, String loc, String mail, String date) throws ParseException, JsonMappingException, JsonProcessingException {
		Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		Employee employee = new Employee(name,loc,mail,dob);
		employeeService.createEmployee(employee);
		ArrayList<Employee> employeeList = employeeService.getEmployees();
		ModelAndView mav = new ModelAndView("employeeDetails");
		mav.addObject("employeeList", employeeList);
		return mav;
	}
	

	@RequestMapping("/employee/{id}")
	public ModelAndView EditForm(@PathVariable("id") Long ecode) {
		System.out.println(ecode);
		Employee employee = employeeService.getEmployeeById(ecode);
//		DateTimeFormatter oldPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
//		DateTimeFormatter newPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
//		LocalDateTime datetime = LocalDateTime.parse(input, oldPattern); 
//		String output = datetime.format(newPattern);

		System.out.println(employee.getEname());
		
		ModelAndView mav = new ModelAndView("EditEmployee");
		mav.addObject("ecode", employee.getEcode());
		mav.addObject("ename", employee.getEname());
		mav.addObject("location", employee.getLocation());
		mav.addObject("email", employee.getEmail());
		mav.addObject("dob", employee.getEdob());
		return mav;
	}
	
	
	@RequestMapping("/editEmployee/{id}")
	public ModelAndView Edit(@PathVariable("id") Long ecode , @RequestParam String name, String loc, String mail, String date) throws ParseException, JsonMappingException, JsonProcessingException {
		System.out.println(ecode);
		Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		employeeService.updateEmployee(ecode, name, loc, mail, dob);
		ArrayList<Employee> employeeList = employeeService.getEmployees();
		ModelAndView mav = new ModelAndView("employeeDetails");
		mav.addObject("employeeList", employeeList);
		return mav;
	}
	
	@RequestMapping("/employeeDelete/{id}")
	public ModelAndView delete(@PathVariable("id") Long ecode) throws JsonMappingException, JsonProcessingException {
		employeeService.deleteEmployee(ecode);
		ArrayList<Employee> employeeList = employeeService.getEmployees();
		ModelAndView mav = new ModelAndView("employeeDetails");
		mav.addObject("employeeList", employeeList);
		return mav;
	}

}
