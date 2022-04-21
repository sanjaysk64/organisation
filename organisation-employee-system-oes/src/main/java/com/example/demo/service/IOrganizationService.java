
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.ast.Or;

import com.example.demo.model.Employee;
import com.example.demo.model.Organisation;

public interface IOrganizationService {

	public Organisation saveRecordEmp(Organisation organisation);

	public List<Employee> getAllDetails();
	
	public Optional<Employee> getById(Integer id);

	public List<Employee> sortedOrderBYName();

	public boolean update(Employee e);

 
	// 2. Get employee details of only Technical dept
	List<Organisation> getEmpBasedOnDep(String dept);

	// 3. Get employee details in sorted order by name from HR dept
	List<Employee> sortByNameDept(String dept);

	// 4. Get employee details in sorted order by years of exp from public relations
	// dept
	List<Employee> sortByExp(String dept);

	// 8. Create an API for employees to resign. Delete his record from the DB
	public boolean delete(Integer id);

	// 5. Add an employee to a specified dept with mentioned details in the payload
	public Organisation addEmp(Integer id, Employee employee);

	public String applyLeave(String name, Integer leaves);

	public List<Employee> appraisalOfEligableEmployee(String dept);

}
