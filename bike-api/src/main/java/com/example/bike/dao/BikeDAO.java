package com.example.bike.dao;

import java.util.List;

import com.example.bike.models.Bike;

public interface BikeDAO {

	Bike getBikeById(Long Id);
	List<Bike> getAllBikes();
	boolean deleteBike(long id);
	boolean updateBike(Bike bike);
	boolean createBike(Bike bike);
}
