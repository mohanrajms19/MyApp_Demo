package customer.myapp.employee;
import java.util.List;

import org.apache.kafka.common.requests.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import customer.myapp.errors.*;

@RestController
public class EmployeeController {
    @Autowired
	EmployeeService employeeService;

    @RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee) throws Exception {
		try {
			return new ResponseEntity<>(employeeService.insertEmployee(employee), HttpStatus.OK);
		} catch (Exception ex) {
			ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(),
					ex.getMessage(), "SM0001");
			return new ResponseEntity<ApiError>(apiError, apiError.getStatus());
		}
	}




}
