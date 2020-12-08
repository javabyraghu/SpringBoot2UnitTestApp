package in.nareshit.raghu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.model.Employee;
import in.nareshit.raghu.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(
			@RequestBody Employee employee) {
		
		Integer id = service.saveEmployee(employee);
		
		return ResponseEntity.ok("Employee saved "+ id);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> list =  service.getAllEmployees();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<Employee> getOneEmployee(
			@PathVariable Integer id) 
	{
		Employee e = service.getOneEmployee(id);
		return ResponseEntity.ok(e);
	}
	
}
