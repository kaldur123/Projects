package springboot.springbootapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.springbootapp.entity.Country;
import springboot.springbootapp.repository.CountryRepository;
import springboot.springbootapp.service.CountryService;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void saveCountry(Country country) {
        countryRepository.save(country);
    }

    @Override
    public List<Country> showCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country showCountryById(int id) {
        return countryRepository.getOne(id);
    }
}
