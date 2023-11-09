package customer.myapp.employee;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;


@Component
//@Entity
@Getter
@Setter

public class EmployeeSearch {
    private Long company_id = 0L;
	private String first_name;
	private String last_name;
	private String email;
	private Long status = 0L;
	
}
