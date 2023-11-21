package customer.myapp.employee;
import java.util.Collection;

// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Primary;

import org.springframework.stereotype.Component;



@Component
@Primary
public class EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    public Collection<Employee> getEmployee() {
        try {
            return employeeDAO.getEmployee(true,0L,null,0,0);
        } catch (Exception e) {
            throw e;
        }
    }

    public EmployeeRequest getEmployeeById(Long id) {
        try {
            return  employeeDAO.getEmployeeById(id);
          
        } catch (Exception ex) {
            throw ex;
        }
    }
    // public Integer DeleteEmployeeById(Long id) {
    //     try {
    //         return employeeDAO.deleteEmployeeById(id);
    //     } catch (Exception exception) {
    //         throw exception;
    //     }
    // }
    

      public Collection<Employee> getEmployeeByFilter(
            EmployeeRequest employeeRequest) {
        try {
            return employeeDAO.getEmployee(false, 0L, employeeRequest, 0, 0);
        } catch (Exception exception) {
            throw exception;
        }
    }
    public Employee addEditEmployee(
            EmployeeRequest employeeRequest) throws Exception {
        try {
            return employeeDAO.addEditEmployee(employeeRequest);
        } catch (Exception exception) {
            throw exception;
        }
    }
}
