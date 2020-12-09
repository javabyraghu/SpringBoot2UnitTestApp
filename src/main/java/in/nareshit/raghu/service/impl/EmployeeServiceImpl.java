package in.nareshit.raghu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.exception.EmployeeNotFoundException;
import in.nareshit.raghu.model.Employee;
import in.nareshit.raghu.repo.EmployeeRepository;
import in.nareshit.raghu.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public Integer saveEmployee(Employee e) {
		return repo.save(e).getEmpId();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		return repo.findById(id).orElseThrow(
				()->new EmployeeNotFoundException("Employee not exist")
				);
	}

	@Override
	public void deleteEmployee(Integer id) {
		Employee e = getOneEmployee(id);
		repo.delete(e);
	}

}
