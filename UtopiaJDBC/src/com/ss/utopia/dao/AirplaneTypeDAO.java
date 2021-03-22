/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.AirplaneType;

/**
 * @author marvin
 *
 */
public class AirplaneTypeDAO extends BaseDAO<AirplaneType> {
	
	public AirplaneTypeDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Read all airplaneTypes
	 * @return
	 * @throws SQLException
	 */
	public List<AirplaneType> readAllAirplaneTypes() throws SQLException {
		return read("SELECT * FROM airplane_type", null);
	}
	
	/**
	 * Read airplaneType with the given id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public AirplaneType readAirplaneTypeById(Integer id) throws SQLException {
		List<AirplaneType> airplaneTypes = read("SELECT * FROM airplane_type WHERE id = ?", new Object[] {id});
		if (airplaneTypes.size() == 0) {
			return null;
		}
		return airplaneTypes.get(0);
	}
	
	/**
	 * Add airplaneType into database
	 * @param airplaneType
	 * @throws SQLException
	 */
	public void addAirplaneType(AirplaneType airplaneType) throws SQLException {
		save("INSERT INTO airplane_type VALUES (?, ?)", new Object[] {airplaneType.getId(), airplaneType.getMaxCapacity()});
	}
	
	/**
	 * Update airplaneType in database
	 * @param airplaneType
	 * @throws SQLException
	 */
	public void updateAirplaneType(AirplaneType airplaneType) throws SQLException {
		save("UPDATE airplane_type SET max_capacity = ? WHERE id = ?", new Object[] {airplaneType.getMaxCapacity(), airplaneType.getId()});
	}
	
	/**
	 * Delete airplaneType from database
	 * @param airplaneType
	 * @throws SQLException
	 */
	public void deleteAirplaneType(AirplaneType airplaneType) throws SQLException {
		save("DELETE FROM airplane_type WHERE id = ?", new Object[] {airplaneType.getId()});
	}

	@Override
	public List<AirplaneType> extractData(ResultSet rs) throws SQLException {
		List<AirplaneType> airplaneTypeList = new ArrayList<>();
		while (rs.next()) {
			AirplaneType airplaneType = new AirplaneType();
			airplaneType.setId(rs.getInt("id"));
			airplaneType.setMaxCapacity(rs.getInt("max_capacity"));
			airplaneTypeList.add(airplaneType);
		}
		return airplaneTypeList;
	}
	
}
