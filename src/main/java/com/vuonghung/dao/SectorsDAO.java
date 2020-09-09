package com.vuonghung.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/*import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;*/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vuonghung.model.Items;
import com.vuonghung.model.ItemsMapper;
import com.vuonghung.model.Sectors;
import com.vuonghung.model.SectorsMapper;
import com.vuonghung.model.UserAccount;

@Repository
@Transactional
public class SectorsDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void save(Sectors sectors) {
		//String sql = "INSERT INTO SM_Sectors (Sec_Id,Sec_Name, Sec_Status) VALUES (?,?, ?)";
		String sql="{CALL Insert_Sectors(?,?,?,?)}";
		jdbcTemplate.update(sql,sectors.getId(),sectors.getName(),sectors.getImage(),sectors.getStatus());
	}
	
	public void update(Sectors sectors) {
		String sql = "UPDATE SM_Sectors SET Sec_Name = ?, Sec_Status = ? WHERE Sec_Id = ? ";
		jdbcTemplate.update(sql,sectors.getName(),sectors.getStatus(), sectors.getId());
	}
	
	public void delete(String id) {
		String sql = "DELETE FROM SM_Sectors WHERE Sec_Id = " + id;
		jdbcTemplate.update(sql);
	}
	
	
	public Sectors findByid(String id) {
		String sql = "select * from SM_Sectors where Sec_Id=?";
		return jdbcTemplate.queryForObject(sql, new SectorsMapper(), id);
	}
	
	public List<Sectors> findAll() {
		String sql = "SELECT * FROM SM_Sectors";
		return jdbcTemplate.query(sql, new SectorsMapper());
	}
	
	public List<Items> Findall_Items(){
		String sql = "SELECT * FROM SM_Items";
		return jdbcTemplate.query(sql, new ItemsMapper());
				
	}
	/*public List<Sectors> findAll(int page,int pagesize) {
		
		int from = page*pagesize-(pagesize-1);
    	int to = page*pagesize;
    	ArrayList<Sectors> list = new ArrayList<Sectors>();
    	
    	String query = "{CALL GET_SECTORS(?,?)}";
        ResultSet rs ;
        
        try {
        	CallableStatement stsm = getConnection().prepareCall(query);
        	stsm.setInt(1, from);
        	stsm.setInt(2, to);
        	rs = stsm.executeQuery();
            while (rs.next()) {        
                Sectors sec = new Sectors(); 
    			sec.setId(rs.getString("Sec_Id"));
                sec.setName(rs.getString("Sec_Name"));
                //sec.setImage(rs.getString("Sec_Image"));
                //sec.setStatus(rs.getInt("Sec_Status"));
                String chuoi=null;
                
                String ad = rs.getString("Sec_Status");
                if(ad.equals("1")) {
                	chuoi = "Còn hàng";
                }
                else
                	if(ad.equals("2")) {
                		chuoi = "Hết hàng";
                	}
                //int cd = Integer.parseInt(chuoi);
                sec.setStatus(chuoi);
                list.add(sec);
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        return list;
    	
		String sql = "SELECT * FROM SM_Sectors";
		return jdbcTemplate.query(sql, new SectorsMapper());
	}*/
	
	/*public UserAccount findsectors(String userName, String password) throws ClassNotFoundException, SQLException {
		Connection conn = Connectsql.getSQLServerConnection_SQLJDBC();
		CallableStatement pstm = conn.prepareCall("{call SELECT_STAFFS(?,?)}");
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            return user;
        }
        return null;
	}*/
	
}
