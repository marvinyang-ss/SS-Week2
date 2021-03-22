/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Flight;

/**
 * @author marvin
 *
 */
public class FlightDAO extends BaseDAO<Flight> {
	
	public FlightDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Read all flights
	 * @return
	 * @throws SQLException
	 */
	public List<Flight> readAllFlights() throws SQLException {
		return read("SELECT * FROM flight", null);
	}
	
	/**
	 * Read flight with the given id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Flight readFlightById(Integer id) throws SQLException {
		List<Flight> flights = read("SELECT * FROM flight WHERE id = ?", new Object[] {id});
		if (flights.size() == 0) {
			return null;
		}
		return flights.get(0);
	}
	
	/**
	 * Add flight into database
	 * @param flight
	 * @throws SQLException
	 */
	public void addFlight(Flight flight) throws SQLException {
		save("INSERT INTO flight VALUES (?, ?, ?, ?, ?, ?)", 
			new Object[] {
				flight.getId(), 
				flight.getRoute().getId(), 
				flight.getAirplane().getId(), 
				flight.getDepartureTime().toString(), 
				flight.getReservedSeats(), 
				flight.getSeatPrice()
			}
		);
	}
	
	/**
	 * Update flight in database
	 * @param flight
	 * @throws SQLException
	 */
	public void updateFlight(Flight flight) throws SQLException {
		save("UPDATE flight SET "
				+ "route_id = ?, "
				+ "airplane_id = ?, "
				+ "departure_time = ?, "
				+ "reserved_seats = ?, "
				+ "seat_price = ? "
				+ "WHERE id = ?", 
			new Object[] { 
				flight.getRoute().getId(), 
				flight.getAirplane().getId(), 
				flight.getDepartureTime().toString(), 
				flight.getReservedSeats(), 
				flight.getSeatPrice(),
				flight.getId()
			}
		);
	}
	
	/**
	 * Delete flight from database
	 * @param flight
	 * @throws SQLException
	 */
	public void deleteFlight(Flight flight) throws SQLException {
		save("DELETE FROM flight WHERE id = ?", new Object[] {flight.getId()});
	}

	@Override
	public List<Flight> extractData(ResultSet rs) throws SQLException {
		List<Flight> flightList = new ArrayList<>();
		while (rs.next()) {
			try {
				Flight flight = new Flight();
				flight.setId(rs.getInt("id"));
				flight.setRoute(new RouteDAO(conn).readRouteById(rs.getInt("route_id")));
				flight.setAirplane(new AirplaneDAO(conn).readAirplaneById(rs.getInt("airplane_id")));
				flight.setDepartureTime(rs.getObject("departure_time", LocalDateTime.class));
				flight.setReservedSeats(rs.getInt("reserved_seats"));
				flight.setSeatPrice(rs.getFloat("seat_price"));
				flightList.add(flight);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flightList;
	}
	
}
