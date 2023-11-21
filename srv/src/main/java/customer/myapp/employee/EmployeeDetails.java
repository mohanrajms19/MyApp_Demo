package customer.myapp.employee;

import java.util.Date;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@Component
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)

@SqlResultSetMapping(name = "EmployeeDetails_Mapping", entities = {
        @EntityResult(entityClass = EmployeeDetails.class, fields = {
                @FieldResult(name = "id", column = "id"),
                @FieldResult(name = "employee_id", column = "employee_id"),
                @FieldResult(name = "employment_type", column = "employment_type"),
                @FieldResult(name = "start_date", column = "start_date"),
                @FieldResult(name = "end_date", column = " end_date"),
                @FieldResult(name = "created_by", column = "created_by"),
                @FieldResult(name = "created_on", column = "created_on"),
                @FieldResult(name = "modified_by", column = "modified_by"),
                @FieldResult(name = "modified_on", column = "modified_on"),
                @FieldResult(name = "status", column = "status")
        }),
        @EntityResult(entityClass = Employee.class, fields = {
                @FieldResult(name = "id", column = "id")
            
        })
})
public class EmployeeDetails {
    @Id
    private Long id = 0L;

    private Long employee_id;

    private String employment_type;

   
    private String start_date;
   
    private String end_date;

    private Long created_by;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_on;

    
    private Long modified_by;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modified_on;

    private Integer status;
}
