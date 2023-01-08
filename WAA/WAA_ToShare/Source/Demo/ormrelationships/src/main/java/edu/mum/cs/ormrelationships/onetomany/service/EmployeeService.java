package edu.mum.cs.ormrelationships.onetomany.service;

import edu.mum.cs.ormrelationships.onetomany.domain.Employee;
import edu.mum.cs.ormrelationships.onetomany.domain.Phone;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;


public interface EmployeeService {

	public List<Employee> getAll();

	public Employee save(Employee employee);

	public Employee get(Long id);

	public List<Employee> findByLastName(String lastName);

	public List<Employee> findEmployeesByLastName(String lastName);

	public List<Phone> findPhones(Long id);

	public Employee findById(long id);

	public List<Employee> findByFirstNameContaining(String name);
}
