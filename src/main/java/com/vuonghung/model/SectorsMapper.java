package com.vuonghung.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SectorsMapper implements RowMapper<Sectors>{

	public Sectors mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sectors sec = new Sectors();
		sec.setId(rs.getString("Sec_Id"));
		sec.setName(rs.getString("Sec_Name"));
		sec.setImage(rs.getString("Sec_Image"));
		String chuoi=null;
		String tt = rs.getString("Sec_Status");
		if(tt.equals("1")) {
			chuoi="Còn hàng";
		}
		else
			if(tt.equals("2")) {
				chuoi="Hết hàng";
			}
		sec.setStatus(chuoi);
		return sec;
	}
}
