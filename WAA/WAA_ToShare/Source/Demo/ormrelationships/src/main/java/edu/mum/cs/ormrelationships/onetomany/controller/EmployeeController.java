package edu.mum.cs.ormrelationships.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import edu.mum.cs.ormrelationships.onetomany.domain.Employee;
import edu.mum.cs.ormrelationships.onetomany.domain.Phone;
import edu.mum.cs.ormrelationships.onetomany.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;






	@RequestMapping(value = "/OneToManyUniJoinColumn", method = RequestMethod.GET)
	public ModelAndView doOneToManyUniJoinColumn() {




		List<Phone> phones = new ArrayList<Phone>();
		List<Phone> phones2 = new ArrayList<Phone>();

		Phone phone = new Phone();
		phone.setAreaCode(222);
		phone.setPrefix(333);
		phone.setNumber(5432);
		phones.add(phone);

		phone = new Phone();
		phone.setAreaCode(111);
		phone.setPrefix(444);
		phone.setNumber(2345);
		phones.add(phone);

		phone = new Phone();
		phone.setAreaCode(666);
		phone.setPrefix(666);
		phone.setNumber(6666);

		phone = new Phone();
		phone.setAreaCode(333);
		phone.setPrefix(444);
		phone.setNumber(9999);
		phones.add(phone);

		Phone phone2 = new Phone();
		phone2.setAreaCode(333);
		phone2.setPrefix(333);
		phone2.setNumber(333);
		phones2.add(phone2);


		Employee employee = new Employee();
		employee.setFirstName("Julliane");
		employee.setLastName("Adam");
		employee.setSalary(120000);

		employee.setPhones(phones);

		employee = employeeService.save(employee);

		employee = new Employee();
		employee.setFirstName("Moe");
		employee.setLastName("Ibrahim");
		employee.setSalary(40000);
		employeeService.save(employee);

		Employee employee2 = new Employee();
		employee2.setFirstName("Zaineh");
		employee2.setLastName("Dean");
		employee2.setSalary(180000);
		employee2.setPhones(phones2);
		employeeService.save(employee2);


		employeeService.findByFirstNameContaining("Bill").stream().forEach(System.out::println);

		employeeService.findEmployeesByLastName("Pay").stream().forEach(System.out::println);
			Long i = 1L;
		System.out.println("This ONE");
		employeeService.findPhones(i).stream().map(p -> p.getAreaCode()).forEach(System.out::println);

		System.out.println("This TWO");
		Employee empsam = employeeService.findById(i);
		System.out.println(empsam.getFirstName());

		ModelAndView mav = new ModelAndView();
		mav.addObject(employee);
		mav.setViewName("onetomany/EmployeeDetails");

		return mav;
	}

}
