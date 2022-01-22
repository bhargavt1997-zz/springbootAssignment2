package com.example.assignment2.milestone.controller;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.assignment2.milestone.model.Netflix;
import com.example.assignment2.milestone.service.MilestoneService;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MilestoneController {

	@Autowired
	private MilestoneService milestoneService;

	@RequestMapping(value = "/AllMovies", method = RequestMethod.GET)
	public List<Netflix> getAllMovies() {
		return milestoneService.getAllMovies();
	}

	@PostMapping("/upload")
	public String uploadedData(@RequestParam("file") MultipartFile file) throws Exception {
		List<Netflix> movieList = new ArrayList<>();
		InputStream inputStream = file.getInputStream();
		CsvParserSettings setting = new CsvParserSettings();
		setting.setHeaderExtractionEnabled(true);
		CsvParser parser = new CsvParser(setting);
//		List<Record> parseAllRecords=parser.parseAllRecords(inputStream);
		List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
		parseAllRecords.forEach(record -> {
			Netflix row=new Netflix();
			row.setShowId(record.getString("Show_id"));
			row.setType(record.getString("type"));
			row.setTitle(record.getString("title"));
			row.setDirector(record.getString("director"));
			row.setCast(record.getString("cast"));
			row.setCountry(record.getString("country"));
			row.setDateAdded(record.getString("date_added"));
			row.setReleaseYear(Integer.parseInt(record.getString("release_year")));
			row.setRating(record.getString("rating"));
			row.setDuration(record.getString("duration"));
			row.setListedIn(record.getString("listed_in"));
			row.setDescription(record.getString("description"));
			movieList.add(row);
		});
		service.saveAll(movieList);
		return "Uploaded Sucessfully";
	}

	
}

