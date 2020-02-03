package com.example.readcsvfile.repository;


import com.example.readcsvfile.model.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country,Integer> {

}
