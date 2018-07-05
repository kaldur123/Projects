package hospital.entity.enumer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    ROLE_DOCTOR("Doctor"), ROLE_RECEPTION("Reception"), ROLE_CLIENT("Client");

    private String roleUser;
}
