package customer.myapp.employees;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

// import customer.myapp.employee.Employee;
import customer.myapp.employees.Employees;
import customer.myapp.employees.EmployeesService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeesController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    EmployeesService employeesService;

    // @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	// public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
	// 	return new ResponseEntity<>(employeesService.getEmployeeById(id), HttpStatus.OK);
	// }

	// @RequestMapping(path = "/employees", method = RequestMethod.GET)
	// public ResponseEntity<?> getAllEmployees() throws Exception {
	// 	return new ResponseEntity<>(employeesService.getAllEmployees(), HttpStatus.OK);
	// }

    @RequestMapping("/employee/count")
	public long count() {
		//log.info("Search total number of employees");
		return employeesService.getCount();
	}

    @RequestMapping("/employee/all")
	public List<Employees> getAllEmployees(){
		log.info("Searching all employees");
		return employeesService.findAllEmployees();
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/employee/add")
	public boolean addEmployee(@RequestBody Employees employees) {
		
		log.info("Creation/Updating Employee - "+employees.toString());
		return employeesService.insertemployees(employees);
	}
	
	@RequestMapping("/employee/id/{id}" )
	public Employees findById(@PathVariable long id) {
		log.info("Searching employee with ID - "+ id);
		return employeesService.findEmployeesById(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employee/delete/{id}")
	public boolean deleteEmployees(@PathVariable long id) {
		return employeesService.deleteEmployees(id);
	}
	
}
