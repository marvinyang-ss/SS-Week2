/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airport;

/**
 * @author marvin
 *
 */
public class AirportDAO extends BaseDAO<Airport> {
	
	public AirportDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Read all airports
	 * @return
	 * @throws SQLException
	 */
	public List<Airport> readAllAirports() throws SQLException {
		return read("SELECT * FROM airport", null);
	}
	
	/**
	 * Read airport with the given iata id
	 * @param iataId
	 * @return
	 * @throws SQLException
	 */
	public Airport readAirportById(String id) throws SQLException {
		List<Airport> airports = read("SELECT * FROM airport WHERE iata_id = ?", new Object[] {id});
		if (airports.size() == 0) {
			return null;
		}
		return airports.get(0);
	}
	
	/**
	 * Add airport into database
	 * @param airport
	 * @throws SQLException
	 */
	public void addAirport(Airport airport) throws SQLException {
		save("INSERT INTO airport VALUES (?, ?)", new Object[] {airport.getId(), airport.getCity()});
	}
	
	/**
	 * Update airport in database
	 * @param airport
	 * @throws SQLException
	 */
	public void updateAirport(Airport airport) throws SQLException {
		save("UPDATE airport SET city = ? WHERE iata_id = ?", new Object[] {airport.getCity(), airport.getId()});
	}
	
	/**
	 * Delete airport from database
	 * @param airport
	 * @throws SQLException
	 */
	public void deleteAirport(Airport airport) throws SQLException {
		save("DELETE FROM airport WHERE iata_id = ?", new Object[] {airport.getId()});
	}

	@Override
	public List<Airport> extractData(ResultSet rs) throws SQLException {
		List<Airport> airportList = new ArrayList<>();
		while (rs.next()) {
			Airport airport = new Airport();
			airport.setId(rs.getString("iata_id"));
			airport.setCity(rs.getString("city"));
			airportList.add(airport);
		}
		return airportList;
	}
	
}
