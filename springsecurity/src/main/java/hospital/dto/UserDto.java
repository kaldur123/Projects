package hospital.dto;

import hospital.entity.enumer.UserRole;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {

    private String login;

    private String password;

    private int phoneNumber;

    private LocalDate date;

//    private String day;
//
//    private String month;
//
//    private String year;

    private String city;

    private String street;

    private UserRole role;
}
