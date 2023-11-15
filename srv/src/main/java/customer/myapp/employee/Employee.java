package customer.myapp.employee;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.util.Date;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Component
@Getter
@Setter
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@SqlResultSetMapping(name = "Employee_Mapping", classes = @ConstructorResult(targetClass = Employee.class, columns = {
        @ColumnResult(name = "id", type = Long.class),
        @ColumnResult(name = "first_name", type = String.class),
        @ColumnResult(name = "gender", type = String.class),
        @ColumnResult(name = "marital_status", type = String.class),
        @ColumnResult(name = "dob", type = Date.class),
        @ColumnResult(name = "email", type = String.class),
        @ColumnResult(name = "mobile", type = String.class),
        @ColumnResult(name = "created_by", type = Date.class),
        @ColumnResult(name = "created_on", type = Date.class),
        @ColumnResult(name = "modified_by", type = Date.class),
        @ColumnResult(name = "modified_on", type = Date.class),
        @ColumnResult(name = "status", type = Integer.class),
        @ColumnResult(name = "record_count", type = Integer.class)
}))
public class Employee {
    @Id

    private Long id;

    private String first_name;

    private String gender;

    private String marital_status;

    private Date dob;

    private String email;

    private String mobile;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_by;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_on;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modified_by;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modified_on;

    private Integer status;

    private Integer record_count;

    public Employee() {
        // Default contstructor
    }

public Employee(Long id, String first_name,String gender,String marital_status,Date dob,String email,String mobile,Date created_by,Date created_on,Date modified_by,Date modified_on, Integer status,Integer record_count){
    this.id =id;
    this.first_name = first_name;
    this.gender = gender;
    this.marital_status = marital_status;
    this.dob =dob ;
    this.email =email ;
    this.mobile =mobile ;
    this.created_by =created_by ;
    this.created_on =created_on ;
    this.modified_by =modified_by ;
    this.modified_on =modified_on ;
    this.status =status ;
    this.record_count =record_count ;
}
}
