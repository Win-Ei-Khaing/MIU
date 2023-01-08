package edu.mum.cs.ormrelationships.onetomany.repository;

import java.util.List;

import edu.mum.cs.ormrelationships.onetomany.domain.Employee;
import edu.mum.cs.ormrelationships.onetomany.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Query("select e from Employee e where e.id = :id")
	Employee findByName(@Param("id") long id);

	@Query("select e from Employee e where e.id = :id")
	Employee findById(@Param("id") long id);

	@Query("select e.phones from Employee e where e.id = :id")
	public List<Phone> findPhones(@Param("id") long id);

	@Query(value = "SELECT e FROM Employee e WHERE e.lastName like %:lastname%")
	public List<Employee> findByLastName(String lastname);


	List<Employee> findByFirstNameContaining(String firstName);


	@Query(value = "SELECT * FROM Employee e WHERE e.F_NAME = ?1", nativeQuery = true)
	public List<Employee> findByFirstName(String firstName);

	public List<Employee> findEmployeesByLastName(@Param("lastName") String lastName);




}
