package springboot.springbootapp.dto.filter;

import lombok.Data;

@Data
public class MyFilter {
    String searchFirstName;
    String searchLastName;
    String searchEmail;
    String searchLogin;
    String searchMinSalary;
    String searchMaxSalary;
    int size;
}
