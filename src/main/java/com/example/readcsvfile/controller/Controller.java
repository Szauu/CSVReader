package com.example.readcsvfile.controller;


import com.example.readcsvfile.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class Controller {

    @Autowired
    private CountryService countryService;

    @RequestMapping("/feedCountryData")
    public void setDataInDB() throws FileNotFoundException {
        countryService.saveCountryData();
    }

    @GetMapping("/freedom")
    public void getFreedom() {
        countryService.getFreedom();
    }


    @GetMapping("/corruption")
    public void getCorruption() {
        countryService.getCorruption();
    }

    @GetMapping("/happiness")
    public void getHappierThanPoland() {
        countryService.getHappiness();
    }

}
