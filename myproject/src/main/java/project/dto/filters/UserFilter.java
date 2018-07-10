package project.dto.filters;

import lombok.Data;

@Data
public class UserFilter {

    String searchFullName;
    String searchAge;
    String searchEmail;
    String searchCountry;
    int size;
}
