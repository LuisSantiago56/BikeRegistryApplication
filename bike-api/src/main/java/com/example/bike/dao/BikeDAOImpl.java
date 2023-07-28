package com.example.bike.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.bike.models.Bike;
import com.example.bike.models.BikeMapper;

@Component
public class BikeDAOImpl implements BikeDAO {
	
	JdbcTemplate jdbc;
	
	private final String SQL_FIND_BIKE_BY_ID = "select * from bike where id = ?";
	private final String SQL_GET_ALL_BIKES = "select * from bike";
	private final String SQL_DELETE_BIKE = "delete from bike where id = ?";
	private final String SQL_UPDATE_BIKE = "update bike set name = ?, email = ?, phone = ?, contact = ?, purchase_date = ?, purchase_price = ?, model = ?, serial_number = ?";
	private final String SQL_INSERT_BIKE = "insert into bike(name, email, phone, contact, purchase_date, purchase_price, model, serial_number) values (?,?,?,?,?,?,?,?)";

	@Autowired
	public BikeDAOImpl(DataSource dt) {
		jdbc = new JdbcTemplate(dt);
	}
	@Override
	public Bike getBikeById(Long Id) {
		// TODO Auto-generated method stub
		return jdbc.queryForObject(SQL_FIND_BIKE_BY_ID, new Object[] {Id}, new BikeMapper());
	}

	@Override
	public List<Bike> getAllBikes() {
		// TODO Auto-generated method stub
		return jdbc.query(SQL_GET_ALL_BIKES, new BikeMapper());
	}

	@Override
	public boolean deleteBike(long id) {
		// TODO Auto-generated method stub
		return jdbc.update(SQL_DELETE_BIKE, id) > 0;
	}

	@Override
	public boolean updateBike(Bike bike) {
		// TODO Auto-generated method stub
		return jdbc.update(SQL_UPDATE_BIKE,
				bike.getName(), bike.getEmail(),
				bike.getPhone(), bike.getContact(),
				bike.getPurchaseDate(), bike.getPurchasePrice(),
				bike.getModel(), bike.getSerialNumber()) > 0;
	}

	@Override
	public boolean createBike(Bike bike) {
		// TODO Auto-generated method stub
		return jdbc.update(SQL_INSERT_BIKE,
				bike.getName(), bike.getEmail(),
				bike.getPhone(), bike.getContact(),
				bike.getPurchaseDate(), bike.getPurchasePrice(),
				bike.getModel(), bike.getSerialNumber()) > 0;
	}

}
