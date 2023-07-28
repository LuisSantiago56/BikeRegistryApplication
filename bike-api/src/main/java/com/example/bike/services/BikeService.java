package com.example.bike.services;

import java.util.List;

import com.example.bike.models.Bike;

public interface BikeService {

	Bike GetBikeById(long id);
	List<Bike> GetAllBikes();
	void updateBike(Bike bike);
	void deleteBike(long id);
	void createBike(Bike bike);
}
