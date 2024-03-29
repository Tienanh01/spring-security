package com.example.project1.Controller;

import com.example.project1.Repository.CountryRepository;
import com.example.project1.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;
    @PostMapping("/home/country")
    public void insert(@RequestBody  Country country){

        System.out.println("da vao day ");
        countryRepository.save(country);

    }
    @PostMapping("/home/get")
    public List<Country> getList(){
        List<Country> list = countryRepository.findAll();

        return list;


    }
}
