package customer.myapp.employe;

import org.springframework.stereotype.Component;
 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 
import javax.persistence.Entity;
 
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.ConstructorResult;
import javax.persistence.Id;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
 
import java.security.Timestamp;
import java.sql.Time;
import java.util.Date;
import javax.persistence.ColumnResult;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@SqlResultSetMapping(name = "employee_mapping", classes =
@ConstructorResult(targetClass = Employe.class, columns = {
@ColumnResult(name = "id", type = Long.class),
@ColumnResult(name = "first_name", type = String.class)
 
}))

@Entity
@Getter
@Setter
public class Employe {
    @Id
    private Long id;
    private String first_name;

    public Employe(){
 
    }
    public Employe(Long id, String first_name)
    {
    this.id = id;
    this.first_name = first_name;
    }
}
