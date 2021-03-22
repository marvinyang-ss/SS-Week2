/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author marvin
 *
 */
public abstract class BaseDAO<T> {
	protected Connection conn = null;
	
	public BaseDAO(Connection conn) {
		this.conn = conn;
	}
	
	public Integer save(String sql, Object[] vals) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		if (vals != null) {
			for (int i = 0; i < vals.length; i++) {
				ps.setObject(i+1, vals[i]);
			}
		}
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			return rs.getInt(1);
		}
		return null;
	}
	
	public List<T> read(String sql, Object[] vals) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(sql);
		if (vals != null) {
			for (int i = 0; i < vals.length; i++) {
				ps.setObject(i+1, vals[i]);
			}
		}
		ResultSet rs = ps.executeQuery();
		
		return extractData(rs);
	}
	
	abstract public List<T> extractData(ResultSet rs) throws SQLException;
}
