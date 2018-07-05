package hospital.mapper;

import hospital.dto.UserDto;
import hospital.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserMapper {

    public static org.springframework.security.core.userdetails.User toSecurityUser(User user) {
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().getRoleUser()));
    }

    public static User convertToUser(UserDto userDto) {
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setAddress(userDto.getCity() + ", " + userDto.getStreet());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setDate(userDto.getDate());
        //user.setDate(LocalDate.parse((userDto.getYear() + "." + userDto.getMonth()+ "." + userDto.getDay()), DateTimeFormatter.ofPattern("yyyy/MMMM/dd")));
        return user;

    }
}
