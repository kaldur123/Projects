package springboot.springbootapp.mapper;

import springboot.springbootapp.dto.UserDto;
import springboot.springbootapp.entity.User;

public interface UserMapper {

    static User convert(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setLogin(userDto.getLogin());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setSalary(userDto.getSalary());
        user.setPass(userDto.getPass());
        return user;
    }
}
