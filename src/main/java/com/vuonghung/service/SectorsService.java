package com.vuonghung.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vuonghung.dao.Connectsql;
import com.vuonghung.dao.ItemsDAO;
import com.vuonghung.dao.SectorsDAO;
import com.vuonghung.model.Items;
import com.vuonghung.model.Sectors;
import com.vuonghung.model.UserAccount;


@Service
@Transactional
public class SectorsService {

	@Autowired
	private SectorsDAO sectorsDAO;
	//private ItemsDAO itemsDAO;
	
	public List<Sectors> findAll() {
		return sectorsDAO.findAll();
	}
	
	public List<Items> findall_items(){
		return sectorsDAO.Findall_Items();
	}
	
	public Sectors findById(String id) {
		return sectorsDAO.findByid(id);
	}
	
	/*public UserAccount findsec(String userName, String password) throws ClassNotFoundException, SQLException {
		return sectorsDAO.findsectors(userName, password);
	}*/
	
	public void save(Sectors sectors){
		// validate business
		sectorsDAO.save(sectors);
	}

	public void update(Sectors sectors){
		// validate business
		sectorsDAO.update(sectors);
	}
	
	public void delete(String id){
		// validate business
		sectorsDAO.delete(id);
	}
	
	private Connection getConnection() throws SQLException,ClassNotFoundException {
	    Connection con = Connectsql.getSQLServerConnection_SQLJDBC();
	    return con;
	}
	
	public int getcountSectors() {
		int rows=0;
		String query = "{CALL COUNT_SECTORS}";
		ResultSet rs;
		try {
			CallableStatement stsm = getConnection().prepareCall(query);
			rs = stsm.executeQuery();
			if(rs.next()) {
				rows = rs.getInt("TOTAL");
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			
		}
		return rows;
	}
}
