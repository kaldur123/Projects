package hospital.entity.enumer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    WAITING("Waiting"), REGECTED("Regected"), ACCEPTED("Accepted");
    private String status;
}
