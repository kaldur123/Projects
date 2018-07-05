package springboot.springbootapp.service;

import springboot.springbootapp.entity.Country;

import java.util.List;

public interface CountryService {

    void saveCountry(Country country);

    List<Country> showCountries();

    Country showCountryById(int id);
}
