package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.StuRegistrationModel;

public interface StuRegistrationRepository extends CrudRepository<StuRegistrationModel, Integer> {

}
