package com.example.bike.services;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.bike.config.AppConfig;
import com.example.bike.dao.BikeDAO;
import com.example.bike.models.Bike;

@Service
public class BikeServiceImpl implements BikeService{

//	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//	BikeDAO bikeDao = ctx.getBean(BikeDAO.class);
	private final BikeDAO bikeDao;
	
	@Autowired
	public BikeServiceImpl(BikeDAO bikedao) {
		bikeDao = bikedao;
	}
	
	public List<Bike> GetAllBikes(){
		return bikeDao.getAllBikes();
	}
	
	public Bike GetBikeById(long id) {
		return bikeDao.getBikeById(id);
	}
	
	public void updateBike(Bike bike) {
		bikeDao.updateBike(bike);
	}
	
	public void deleteBike(long id) {
		bikeDao.deleteBike(id);
	}
	
	public void createBike(Bike bike) {
		bikeDao.createBike(bike);
	}
}
