package com.crud.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.demo.model.Country;

@Repository
public interface ICountryRepository extends JpaRepository<Country, Long>{

}
