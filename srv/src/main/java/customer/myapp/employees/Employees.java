package customer.myapp.employees;

import javax.persistence.*;
import java.util.Date;
// import org.springframework.stereotype.Component;

// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

// @SuppressWarnings("serial")
// @Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
// @JsonIgnoreProperties(ignoreUnknown = true)
// @Table(name = "employee")
public class Employees {

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date created_on;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_on", nullable = false)
    private Date modified_on;

    @Column(name = "created_by")
    private Long created_by;

    @Column(name = "modified_by")
    private Long modified_by;

    @Column(name = "status")
    private int status;
}
