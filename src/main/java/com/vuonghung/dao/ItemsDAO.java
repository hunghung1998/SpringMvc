package com.vuonghung.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vuonghung.model.Items;
import com.vuonghung.model.ItemsMapper;

@Repository
@Transactional
public class ItemsDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Items> Findall_Items(){
		String sql = "SELECT * FROM SM_Items";
		return jdbcTemplate.query(sql, new ItemsMapper());
				
	}
}
