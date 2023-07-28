package com.example.bike.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BikeMapper implements RowMapper<Bike> {

	public Bike mapRow(ResultSet rs, int i) throws SQLException {
		Bike bike = new Bike();
		bike.setId(rs.getInt("id"));
		bike.setContact(rs.getBoolean("contact"));
		bike.setEmail(rs.getString("email"));
		bike.setModel(rs.getString("model"));
		bike.setName(rs.getString("name"));
		bike.setPhone(rs.getString("phone"));
		bike.setPurchaseDate(rs.getDate("purchase_date"));
		bike.setPurchasePrice(rs.getBigDecimal("purchase_price"));
		bike.setSerialNumber(rs.getString("serial_number"));
		
		return bike;
	}
}
