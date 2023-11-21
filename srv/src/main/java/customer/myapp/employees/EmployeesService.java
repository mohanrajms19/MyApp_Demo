package customer.myapp.employees;

// import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import customer.myapp.employees.Employees;
import customer.myapp.employees.EmployeesDAO;


@Service
// @Primary
public class EmployeesService {
    @Autowired
    private EmployeesDAO employeesDAO;

    // public Employees insertEmployees(Employees employees){
    //     try{
    //         return employeesDAO.save(employees);
    //     }catch(Exception e){
    //         throw e;
    //     }
    // }

    // public Collection<Employees> getAllEmployees() {
    //     try {
    //         return employeesDAO.findAll();
    //     } catch (Exception e) {
    //         throw e;
    //     }
    // }

    // public Optional<Employees> getEmployeeById(Long id) {
    //     try {
    //         Optional<Employees> employee = employeesDAO.findById(id);
    //         return employee;
    //     } catch (Exception ex) {
    //         throw ex;
    //     }
    // }

    public long getCount(){
        long count = employeesDAO.count();
        return count;
    }

    public List<Employees> findAllEmployees(){
        List<Employees> employees = new ArrayList<>();
        employeesDAO.findAll().forEach(employees::add);
        return employees;
    }
    public boolean insertemployees(Employees employees){        
        try{
            employeesDAO.save(employees);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }   

    public Employees findEmployeesById(Long id){
        Employees employees = employeesDAO.findById(id).orElse(null);
        return employees;
    }

    public boolean deleteEmployees(long id){
        Employees employees = employeesDAO.findById(id).orElse(null);
        if(employees != null){
            employeesDAO.delete(employees);
            return true;
        }
        return false;
    }
}
