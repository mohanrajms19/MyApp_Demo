package customer.myapp.employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.StoredProcedureQuery;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import java.io.IOException;
import java.sql.*;

@Component
public class EmployeeDAO{
    @PersistenceContext
    private EntityManager entityManager;

    public Collection<Employee> getEmployee(boolean isAllRecords, long id, EmployeeRequest employeeRequest, Integer PageNumber, Integer pageSize){
        try{
            String filterParams ="";
            if (employeeRequest != null){
                // filterParams = new Gson().toJson(employeeRequest);
            }
            employeeRequest = employeeRequest == null ? new EmployeeRequest() : employeeRequest;

            StoredProcedureQuery sp_Employee = entityManager.createStoredProcedureQuery("employee_create","Employee_Mapping");
            sp_Employee.registerStoredProcedureParameter("SHOW_ALL", Boolean.class, ParameterMode.IN);
            sp_Employee.registerStoredProcedureParameter("ID", Long.class, ParameterMode.IN);
            sp_Employee.registerStoredProcedureParameter("FILTER_PARAMS", String.class, ParameterMode.IN);
            sp_Employee.registerStoredProcedureParameter("PAGE_NUMBER", Integer.class, ParameterMode.IN);
            sp_Employee.registerStoredProcedureParameter("PAGE_SIZE", Integer.class, ParameterMode.IN);
            // sp_Employee.registerStoredProcedureParameter("SORTING_KEY", String.class, ParameterMode.IN);
            // sp_Employee.registerStoredProcedureParameter("ORDER_BY", String.class, ParameterMode.IN);
            // sp_Employee.registerStoredProcedureParameter("STRING_TYPE", Boolean.class, ParameterMode.IN);

            sp_Employee.setParameter("SHOW_ALL", isAllRecords);
            sp_Employee.setParameter("ID", id);
            sp_Employee.setParameter("FILTER_PARAMS", filterParams);
            sp_Employee.setParameter("PAGE_NUMBER", employeeRequest.getPage_number());
            sp_Employee.setParameter("PAGE_SIZE", employeeRequest.getPage_size());
            // sp_Employee.setParameter("SORTING_KEY", employeeRequest.getSorting_key());
            // sp_Employee.setParameter("ORDER_BY", employeeRequest.getOrder_by());
            // sp_Employee.setParameter("STRING_TYPE", employeeRequest.getString_type());

            sp_Employee.execute();
            @SuppressWarnings("unchecked")
            List<Employee> results = sp_Employee.getResultList();
            return results;    
        }
        catch(Exception exception){
            throw exception;
        }
    }

    public EmployeeRequest getEmployeeById(Long id){
        try{
            StoredProcedureQuery sp_GetEmployee = entityManager.createStoredProcedureQuery("Employee_fetch_id", "EmployeeDetails_Mapping");
            sp_GetEmployee.registerStoredProcedureParameter("ID", Long.class, ParameterMode.IN);
            sp_GetEmployee.setParameter("ID", id);
            sp_GetEmployee.execute();

            @SuppressWarnings("unchecked")
            
            List<Object[]> results = sp_GetEmployee.getResultList();
            Employee empObj = (Employee) results.get(1)[1];
            List<EmployeeDetails> employeeDetails = new ArrayList<>();
            results.stream().forEach((record) -> {
                EmployeeDetails d = (EmployeeDetails) record[0];
                if(d != null){
                    employeeDetails.add(d);
                }
                
            });

            EmployeeRequest responseBody = new EmployeeRequest();
            responseBody.setId(empObj.getId());
            // responseBody.setCreated_by(empObj.getCreated_by());
            responseBody.setCreated_on(empObj.getCreated_on());
            // responseBody.setModified_by(empObj.getModified_by());
            responseBody.setModified_on(empObj.getModified_on());
           
            return responseBody;
        }
        catch (Exception exception) {
            throw exception;
        }
    }

    public Integer DeleteEmployeeById(Long id) {
        Integer ret = -1;
        try {

            StoredProcedureQuery sp_GetPropertyGenerator = entityManager
                    .createStoredProcedureQuery("delete_employee_job_details_id");

            sp_GetPropertyGenerator.registerStoredProcedureParameter("ID", Long.class, ParameterMode.IN);
            sp_GetPropertyGenerator.setParameter("ID", id);
            sp_GetPropertyGenerator.execute();
            ret = 0;
        } catch (Exception exception) {
            throw exception;
        }
        return ret;
    }


     public Employee addEditEmployee(
            EmployeeRequest employeeRequest) throws Exception {
        try {
            String reqPayLoad = new Gson().toJson(employeeRequest);

            StoredProcedureQuery sp_AddEditPropertyGenerator = entityManager
                    .createStoredProcedureQuery("add_edit_employeedetails", "Employee_Mapping");
            sp_AddEditPropertyGenerator.registerStoredProcedureParameter("IN_PARAM", String.class, ParameterMode.IN);
            sp_AddEditPropertyGenerator.registerStoredProcedureParameter("EX_MESSAGE", String.class, ParameterMode.OUT);
            sp_AddEditPropertyGenerator.setParameter("IN_PARAM", reqPayLoad);
            sp_AddEditPropertyGenerator.execute();
            String ex_message = (String) sp_AddEditPropertyGenerator.getOutputParameterValue("EX_MESSAGE");
            // if (ex_message != null && !ex_message.isBlank()) {
            //     throw new BusinessException("PO001", ex_message,
            //             HttpStatus.BAD_REQUEST);
            // }
            List<Employee> results = sp_AddEditPropertyGenerator.getResultList();
            return results.get(0);
        } catch (PersistenceException persistenceException) {
            Throwable cause = persistenceException.getCause();
            if (cause instanceof SQLException) {
                SQLException sqlException = (SQLException) cause;
                System.err.println("SQLException: " + sqlException.getMessage());
                // Handle the SQLException here
                // You can log it, display a message, or perform any other necessary action
            } else {
                // Handle other types of exceptions
                throw persistenceException; // rethrow the exception if you can't handle it here
            }
        } catch (Exception exception) {

            throw exception;
        }
        return null;
    }
}

