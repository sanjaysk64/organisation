package com.example.demo.controller;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.Organisation;
import com.example.demo.service.IOrganizationService;

@RestController
@RequestMapping("/organization")
public class OrganisationController {

	@Autowired
	private IOrganizationService organizationService;

	@PostMapping("/save")
	public ResponseEntity<Organisation> saveEmpRecord(@RequestBody Organisation organisation) {
		return ResponseEntity.ok(organizationService.saveRecordEmp(organisation));
	}

	@GetMapping("getById/{id}")
	public Optional<Employee> getById(@PathVariable Integer id) {
		return organizationService.getById(id);
	}

	public List<Employee> sortedOrderBYName() {
		return organizationService.sortedOrderBYName();
	}

//1. Get all the employee details of the organization

	@GetMapping("/getAll")
	public List<Employee> getAll() {
		return organizationService.getAllDetails();
	}

//2. Get employee details of only Technical dept

	@GetMapping("/get/{dept}")
	List<Organisation> getByDept(@PathVariable String dept) {
		return organizationService.getEmpBasedOnDep(dept);
	}

//3. Get employee details in sorted order by name from HR dept

	@GetMapping("/sortByNameDept/{dep}")
	List<Employee> SortByName(@PathVariable String dep) {
		return organizationService.sortByNameDept(dep);
	}

//4. Get employee details in sorted order by years of exp from public relations dept

	@GetMapping("/sortByexp/{dep}")
	List<Employee> SortByExp(@PathVariable String dep) {
		return organizationService.sortByExp(dep);
	}

//6. Update an employee's years of exp e.g. from 5 to 7
	@PutMapping("/update/{id}")
	public boolean update(@PathVariable Integer id, @RequestBody Employee e) {

		organizationService.update(id, e);
		return true;
	}

//8. Create an API for employees to resign. Delete his record from the DB
	@DeleteMapping("delete/{id}")
	public String deleteById(@PathVariable Integer id) {
		return organizationService.delete(id);
	}

	// 5 updatedddd
	@PutMapping("/saveByDept/{id}")
	public Organisation saveEmpByDept(@PathVariable Integer id, @RequestBody Employee employee) {
		return organizationService.addEmp(id, employee);
	}

//9. Create an API for employees to apply leave. If he/she has already taken 10 leaves, then allow only 1 leave to him with an appropriate meaningful message.
	@GetMapping("applyLeave/{name}/{leaves}")
	public String applyLeave(@PathVariable String name, @PathVariable Integer leaves) {
		

 		return organizationService.applyLeave(name, leaves);

	}
//7. Performance appraisal indicates the percentage of salary hike. e.g. if its 5%, increase the salary by 5% and update the DB with the same. Run appraisal API for any dept, and salary should be updated for all employees in that dept

	@GetMapping("/appraisal/{dept}")
	public List<Employee> employeeAppraisalSalary(@PathVariable String dept) {
		return organizationService.appraisalOfEligableEmployee(dept);
	}

// sorting using streams....
	@GetMapping("sortByStreams/{dep}")
	List<Employee> SortByStreams(@PathVariable String dep) {
		return organizationService.sortByNameDept(dep);
	}

//get by dept using streams
	@GetMapping("getBydept/{dep}")
	List<Organisation> getByDeptStreams(@PathVariable String dep) {
		return organizationService.getEmpBasedOnDepStreams(dep);
	}

}
