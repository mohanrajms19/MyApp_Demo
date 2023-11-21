package customer.myapp.employee;

import java.util.Date;
import java.util.List;

// import javax.persistence.Entity;
// import javax.persistence.Id;
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

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeRequest {
    
    private Long id = 0L;

    private String first_name;

    private String gender;

    private String marital_status;

    private Date dob;

    private String email;

    private String mobile;

    private Long created_by;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_on;

  
    private Long modified_by;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modified_on;

    private Integer status;

    private List<EmployeeDetails> Employee;

    private String sorting_key;
    private String order_by;
    private Boolean string_type;
    private Integer page_number = 0;
    private Integer page_size = 0;
}
