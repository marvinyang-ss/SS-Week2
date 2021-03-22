/**
 * 
 */
package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.utopia.dao.AirportDAO;
import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.dao.RouteDAO;
import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.Route;

/**
 * @author marvin
 *
 */
public class EmployeeService {
	
	Util util = new Util();
	
	public List<Flight> readAllFlights() throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			FlightDAO flightDAO = new FlightDAO(conn);
			return flightDAO.readAllFlights();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public String updateFlight(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			FlightDAO flightDAO = new FlightDAO(conn);
			flightDAO.updateFlight(flight);
			conn.commit();
			return "Successfully updated flight";
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Failed to update flight";
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public Airport readAirportById(String iataId) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			AirportDAO airportDAO = new AirportDAO(conn);
			return airportDAO.readAirportById(iataId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public Route readRouteByAirports(String originId, String destinationId) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			RouteDAO routeDAO = new RouteDAO(conn);
			return routeDAO.readRouteByAirports(originId, destinationId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
