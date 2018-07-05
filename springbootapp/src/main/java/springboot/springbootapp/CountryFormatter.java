package springboot.springbootapp;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import springboot.springbootapp.entity.Country;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CountryFormatter implements Formatter<Country> {
    @Override
    public Country parse(String s, Locale locale) throws ParseException {
        System.out.println("Parse: " + s);
        int countryId = Integer.valueOf(s);
        Country country = new Country();
        country.setId(countryId);
        return country;
    }

    @Override
    public String print(Country country, Locale locale) {
        System.out.println("Print: " + country.getId());
        return String.valueOf(country.getId());
    }
}
