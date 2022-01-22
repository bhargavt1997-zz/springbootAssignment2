package com.example.assignment2.milestone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment2.milestone.model.Netflix;
import com.example.assignment2.milestone.repository.NetflixRepository;

@Service
public class MilestoneService {

	@Autowired
	private NetflixRepository netflixRepository;

	public List<Netflix> getAllMovies() {
		List<Netflix> allMovies= (List<Netflix>) netflixRepository.findAll();
		return allMovies;
	}

}
