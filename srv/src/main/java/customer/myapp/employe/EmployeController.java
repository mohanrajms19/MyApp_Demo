package customer.myapp.employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 


@RestController
@RequestMapping(value = "/Employe")
public class EmployeController {
    @Autowired
    EmployeService employeService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getEmploye()  {
        return new  ResponseEntity<>(employeService.getAllEmploye(), HttpStatus.OK);
    }
}
