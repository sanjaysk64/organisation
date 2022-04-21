package com.example.demo.controller;

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

	@GetMapping("/getAll")
	public List<Employee> getAll() {
		return organizationService.getAllDetails();
	}

	@GetMapping("getById/{id}")
	public Optional<Employee> getById (@PathVariable Integer id){
		return organizationService.getById(id);
	}
	

	public List<Employee> sortedOrderBYName() {
		return organizationService.sortedOrderBYName();
	}

	@PutMapping("/update")
	public boolean update(@RequestBody Employee e) {

		organizationService.update(e);
		return true;
	}

	@GetMapping("/get/{dept}")
	List<Organisation> getByDept(@PathVariable String dept) {
		return organizationService.getEmpBasedOnDep(dept);
	}

	@GetMapping("/sortByNameDept/{dep}")
	List<Employee> SortByName(@PathVariable String dep) {
		return organizationService.sortByNameDept(dep);
	}

	@GetMapping("/sortByexp/{dep}")
	List<Employee> SortByExp(@PathVariable String dep) {
		return organizationService.sortByExp(dep);
	}

	@DeleteMapping("delete/{id}")
	boolean deleteById(@PathVariable Integer id) {
		return organizationService.delete(id);
	}

	@PutMapping("/saveByDept/{id}")
	public Organisation saveEmpByDept(@PathVariable Integer id, @RequestBody Employee employee) {
		return organizationService.addEmp(id, employee);
	}

	@GetMapping("applyLeave/{name}/{leaves}")
	public String applyLeave(@PathVariable String name, @PathVariable Integer leaves) {
		return organizationService.applyLeave(name, leaves);

	}

	@GetMapping("/appraisal/{dept}")
	public List<Employee> employeeAppraisalSalary(@PathVariable String dept) {
		return organizationService.appraisalOfEligableEmployee(dept);
	}

}
