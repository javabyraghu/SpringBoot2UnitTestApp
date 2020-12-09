package in.nareshit.raghu.service;

import java.util.List;

import in.nareshit.raghu.model.Employee;

public interface IEmployeeService {

	public Integer saveEmployee(Employee e);
	public List<Employee> getAllEmployees();
	public Employee getOneEmployee(Integer id);
	public void deleteEmployee(Integer id);
}
