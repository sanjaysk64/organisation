package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.Organisation;
import com.example.demo.repository.IEmployeeRepository;
import com.example.demo.repository.IOrganisationRepository;
import com.example.demo.service.IOrganizationService;

@Service
public class OrganisationServiceImpl implements IOrganizationService {

	@Autowired
	private IOrganisationRepository organisationRepository;

	@Autowired
	private IEmployeeRepository employeeRepository;// for api 1

	@Override
	public Organisation saveRecordEmp(Organisation organisation) {
		return organisationRepository.save(organisation);
	}

	@Override
	public List<Employee> getAllDetails() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> sortedOrderBYName() {
		// TODO Auto-generated method stub
		return employeeRepository.save(null);
	}

	@Override
	public boolean update(Employee e) {
		employeeRepository.save(e);
		return true;
	}
	
	// //2. Get employee details of only Technical dept

	@Override
	public List<Organisation> getEmpBasedOnDep(String dep) {

		List<Organisation> list = organisationRepository.findByDept(dep);
		if (!list.isEmpty()) {
			return list;
		}

		return null;
	}

	@Override
	public List<Employee> sortByNameDept(String dept) {

		List<Organisation> list = organisationRepository.findByDept(dept);// repo
		List<Employee> emp = new ArrayList<Employee>();
		for (Organisation organisation : list) {
			emp = organisation.getEmployees();//list

		}
		Collections.sort(emp, new Comp());

		return emp;

	}
	
	@Override
	public List<Employee> sortByExp(String dept) {

		List<Organisation> list = organisationRepository.findByDept(dept);

		List<Employee> employees = new ArrayList<>();
		for (Organisation organisation : list) {

			employees = organisation.getEmployees();
		}
		Collections.sort(employees, new Comp2());
		return employees;

	}

	@Override
	public boolean delete(Integer id) {
		employeeRepository.deleteById(id);
		return true;
	}

	@Override
	public Organisation addEmp(Integer id, Employee employee) {

		Organisation o = organisationRepository.getById(id);// depid
		List<Employee> emp = new ArrayList<Employee>();
		emp = o.getEmployees();// get emp details
		emp.add(employee);// adding employee...
		o.setEmployees(emp);
		return organisationRepository.save(o);

	}

	@Override
	public String applyLeave(String name, Integer leaves) {

		List<Employee> e = employeeRepository.findByName(name);
		for (Employee employee : e) {

			if (employee.getLeaves() >= 10) {     //comp
				return "only 1 leave granted";

			} else {
				return leaves + "-leaves granted";
			}
		}

		return null;
	}

	@Override
	public List<Employee> appraisalOfEligableEmployee(String dept) {
		List<Organisation> list = organisationRepository.findByDept(dept);
		List<Employee> employees = new ArrayList<Employee>();
		List<Employee> updatesSalaryOfEmployess = new ArrayList<>();

		for (Organisation organisation : list) {
			employees = organisation.getEmployees();

		}
		for (Employee employee : employees) {

			double appraisal = employee.getAppraisal();
			double salary = employee.getSalary();
			double updatedSalary = (salary + (appraisal / 100 * salary));
			employee.setSalary(updatedSalary);
			updatesSalaryOfEmployess.add(employee);

		}
		for (Organisation organisation : list) {
			organisation.setEmployees(updatesSalaryOfEmployess);
			organisationRepository.save(organisation);
		}

		return updatesSalaryOfEmployess;
	}

	@Override
	public Optional<Employee> getById(Integer id) {
 		return employeeRepository.findById(id);

	}
}
