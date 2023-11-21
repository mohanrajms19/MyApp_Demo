package customer.myapp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import customer.myapp.errors.ApiError;
import customer.myapp.utils.AppUtils;

@RestController
@RequestMapping(value = "Employee")
public class EmployeeController {
    @Autowired
	EmployeeService employeeService;

	@GetMapping(value ="")
	public ResponseEntity<?>getEmployee(){
		try{
			return new ResponseEntity<>(employeeService.getEmployee(), HttpStatus.OK);
		}catch(Exception ex){
			return new ResponseEntity<ApiError>(AppUtils.getErrorDetails(ex), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "")
    public ResponseEntity<?> addEditEmployee(
            @RequestBody EmployeeRequest employeeRequest) throws Exception {
        try {
            return new ResponseEntity<>(
                    employeeService.addEditEmployee(employeeRequest),
                    HttpStatus.OK);
        }catch (Exception ex) {
            return new ResponseEntity<ApiError>(AppUtils.getErrorDetails(ex), HttpStatus.BAD_REQUEST);
        }
    }

	@GetMapping(value = "/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(employeeService.getEmployeeById(id),
                    HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<ApiError>(AppUtils.getErrorDetails(ex), HttpStatus.BAD_REQUEST);
        }
    }

    // @RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	// public ResponseEntity<?> createEmployee(@RequestBody Employee employee) throws Exception {
	// 	try {
	// 		return new ResponseEntity<>(employeeService.insertEmployee(employee), HttpStatus.OK);
	// 	} catch (Exception ex) {
	// 		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(),
	// 				ex.getMessage(), "SM0001");
	// 		return new ResponseEntity<ApiError>(apiError, apiError.getStatus());
	// 	}
	// }


}
