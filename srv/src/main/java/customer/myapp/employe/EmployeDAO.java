package customer.myapp.employe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
 
 
 
@Component
// @Repository
@Transactional
public class EmployeDAO {
    @PersistenceContext
    private EntityManager entityManager;
 
    public Collection<Employe> getAllEmploye() {
        try {
            List<Employe> results = new ArrayList<Employe>();
            if (entityManager != null) {
                StoredProcedureQuery spEmployees = entityManager
                .createStoredProcedureQuery("GET_ALL_EMPLOYEES", "employee_mapping");
                spEmployees.execute();
                @SuppressWarnings("unchecked")
                List<Employe> tempResults = spEmployees.getResultList();
                results.addAll(tempResults);
            }
            // else {
            // }
 
            return results;
        } catch (Exception exception) {
            throw exception;
        }
    }
}