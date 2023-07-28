package com.example.bike.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.bike.models.Bike;
import com.example.bike.services.BikeServiceImpl;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	private BikeServiceImpl bs;
	
	@Autowired
	public BikesController(BikeServiceImpl bikeService) {
		this.bs = bikeService;
	}

	@GetMapping
	public List<Bike> list() {
		return bs.GetAllBikes();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Bike bike) {
		bs.createBike(bike);
	}
	
	@GetMapping("/{id}")
	public Bike get(@PathVariable("id") long id) {
		return bs.GetBikeById(id);
	}
	
	@PutMapping
	public void update(@RequestBody Bike bike) {
		bs.updateBike(bike);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") long id) {
		bs.deleteBike(id);
	}
}
