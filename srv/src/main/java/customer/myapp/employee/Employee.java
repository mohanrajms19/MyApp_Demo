package customer.myapp.employee;

import javax.persistence.*;

import org.springframework.stereotype.Component; 

import java.util.Date;

import lombok.*;

@SuppressWarnings("serial")
@Component
@Getter
@Setter
@Entity
public class Employee extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "marital_status")
    private String marital_status;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    
}
