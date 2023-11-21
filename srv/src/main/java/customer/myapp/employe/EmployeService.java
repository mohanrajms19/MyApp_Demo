package customer.myapp.employe;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
 
@Service
@Primary
public class EmployeService {
    @Autowired
    private EmployeDAO employeDAO;

    public  Collection<Employe> getAllEmploye(){
        return employeDAO.getAllEmploye();
     }
}
