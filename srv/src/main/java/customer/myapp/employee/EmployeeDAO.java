package customer.myapp.employee;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployeeDAO extends JpaRepository <Employee, Long>, JpaSpecificationExecutor<Employee> {
    Collection<Employee> findByCompanyId(Long id);
   
    Optional<Employee> findByEmpCode(String empCode);

}
