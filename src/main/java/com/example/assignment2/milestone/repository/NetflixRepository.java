package com.example.assignment2.milestone.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.assignment2.milestone.model.Netflix;

@Repository
public interface NetflixRepository extends CrudRepository<Netflix, String> {

}
