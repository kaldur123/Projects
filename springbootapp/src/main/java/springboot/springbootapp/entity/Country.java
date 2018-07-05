package springboot.springbootapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springboot.springbootapp.Validator.CheckIfCountryExists;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "country")
@Getter @Setter
@NoArgsConstructor
public class Country extends BaseEntity{

    @CheckIfCountryExists
    //@NotNull(message = "Country name field can't be null")
    @NotEmpty(message = "Country name field can't be null")
    private String name;

    @NotNull(message = "Country shortName field can't be null")
    @NotEmpty(message = "Country name field can't be null")
    @Column(name = "short_name")
    private String shortName;

}
