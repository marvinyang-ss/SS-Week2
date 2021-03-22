/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airplane;

/**
 * @author marvin
 *
 */
public class AirplaneDAO extends BaseDAO<Airplane> {
	
	public AirplaneDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Read all airplanes
	 * @return
	 * @throws SQLException
	 */
	public List<Airplane> readAllAirplanes() throws SQLException {
		return read("SELECT * FROM airplane", null);
	}
	
	/**
	 * Read airplane with the given id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Airplane readAirplaneById(Integer id) throws SQLException {
		return read("SELECT * FROM airplane WHERE id = ?", new Object[] {id}).get(0);
	}
	
	/**
	 * Add airplane into database
	 * @param airplane
	 * @throws SQLException
	 */
	public void addAirplane(Airplane airplane) throws SQLException {
		save("INSERT INTO airplane VALUES (?, ?)", new Object[] {airplane.getId(), airplane.getType().getId()});
	}
	
	/**
	 * Update airplane in database
	 * @param airplane
	 * @throws SQLException
	 */
	public void updateAirplane(Airplane airplane) throws SQLException {
		save("UPDATE airplane SET type = ? WHERE id = ?", new Object[] {airplane.getType().getId(), airplane.getId()});
	}
	
	/**
	 * Delete airplane from database
	 * @param airplane
	 * @throws SQLException
	 */
	public void deleteAirplane(Airplane airplane) throws SQLException {
		save("DELETE FROM airplane WHERE id = ?", new Object[] {airplane.getId()});
	}

	@Override
	public List<Airplane> extractData(ResultSet rs) throws SQLException {
		List<Airplane> airplaneList = new ArrayList<>();
		while (rs.next()) {
			Airplane airplane = new Airplane();
			airplane.setId(rs.getInt("id"));
			airplane.setType(new AirplaneTypeDAO(conn).readAirplaneTypeById(rs.getInt("type_id")));
			airplaneList.add(airplane);
		}
		return airplaneList;
	}
	
}
