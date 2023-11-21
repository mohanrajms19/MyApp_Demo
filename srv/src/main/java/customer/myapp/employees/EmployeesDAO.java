package customer.myapp.employees;

import org.springframework.data.repository.CrudRepository;
import customer.myapp.employees.Employees;

public interface EmployeesDAO extends CrudRepository<Employees,Long>{
    
}
