package project.entity.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    ROLE_USER("USER"), ROLE_ADMIN("ADMIN");

    private String role;
}
