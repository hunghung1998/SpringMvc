package com.vuonghung.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ItemsMapper implements RowMapper<Items> {

	public Items mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Items item = new Items();
		item.setId(rs.getString("Ite_Id"));
		item.setName(rs.getString("Ite_Name"));
		item.setSup_id(rs.getString("Sup_Id"));
		item.setSec_id(rs.getString("Sec_Id"));
		item.setPrice(rs.getFloat("Ite_Price"));
		item.setUnit(rs.getString("Ite_Unit"));
		item.setStatus(rs.getInt("Ite_Status"));
		
		return item;
	}
}
