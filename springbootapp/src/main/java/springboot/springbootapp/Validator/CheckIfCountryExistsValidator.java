package springboot.springbootapp.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springboot.springbootapp.repository.CountryRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CheckIfCountryExistsValidator implements ConstraintValidator<CheckIfCountryExists, String> {

    @Autowired private CountryRepository countryRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (countryRepository.findCountryByName(s.toLowerCase()) == null) {
            return true;
        }
        return false;
    }
}
