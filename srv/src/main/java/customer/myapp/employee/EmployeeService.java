package customer.myapp.employee;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    public Employee insertEmployee(Employee employee) {
        try {
            return employeeDAO.save(employee);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Employee> getAllEmployee() {
        try {
            return employeeDAO.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    public Optional<Employee> getEmployeeById(Long id) {
        try {
            Optional<Employee> employee = employeeDAO.findById(id);
            return employee;
        } catch (Exception ex) {
            throw ex;
        }
    }
    // public Collection<Employee> fetchEmployeesByCompanines(EmployeeSearch employeeSearch) {
    //     Collection<Employee> employee = employeeDAO
    //             .findAll(EmployeesSpecifications.withCompanyId(employeeSearch.getCompany_id())
    //                     .and(EmployeesSpecifications.withStatus(employeeSearch.getStatus()))
    //                     .and(EmployeesSpecifications.withFirstName(employeeSearch.getFirst_name()))
    //                     .and(EmployeesSpecifications.withLastName(employeeSearch.getLast_name())));
    //     return employee;
    // }
}
