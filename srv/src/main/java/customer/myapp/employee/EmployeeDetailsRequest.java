package customer.myapp.employee;

import java.util.Date;
import java.util.List;

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

public class EmployeeDetailsRequest {
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
