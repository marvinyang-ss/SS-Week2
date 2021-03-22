/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Route;

/**
 * @author marvin
 *
 */
public class RouteDAO extends BaseDAO<Route> {
	
	public RouteDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Read all routes
	 * @return
	 * @throws SQLException
	 */
	public List<Route> readAllRoutes() throws SQLException {
		return read("SELECT * FROM route", null);
	}
	
	/**
	 * Read route with the given id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Route readRouteById(Integer id) throws SQLException {
		List<Route> routes = read("SELECT * FROM route WHERE id = ?", new Object[] {id});
		if (routes.size() == 0) {
			return null;
		}
		return routes.get(0);
	}
	
	/**
	 * Read route with the given origin and destination
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Route readRouteByAirports(String originId, String destinationId) throws SQLException {
		List<Route> routes = read("SELECT * FROM route WHERE origin_id = ? AND destination_id = ?", new Object[] {originId, destinationId});
		if (routes.size() == 0) {
			return null;
		}
		return routes.get(0);
	}
	
	/**
	 * Add route into database
	 * @param route
	 * @throws SQLException
	 */
	public void addRoute(Route route) throws SQLException {
		save("INSERT INTO route VALUES (?, ?, ?)", new Object[] {route.getId(), route.getOrigin().getId(), route.getDestination().getId()});
	}
	
	/**
	 * Update route in database
	 * @param route
	 * @throws SQLException
	 */
	public void updateRoute(Route route) throws SQLException {
		save("UPDATE route SET origin_id = ?, destination_id = ? WHERE id = ?", new Object[] {route.getOrigin().getId(), route.getDestination().getId(), route.getId()});
	}
	
	/**
	 * Delete route from database
	 * @param route
	 * @throws SQLException
	 */
	public void deleteRoute(Route route) throws SQLException {
		save("DELETE FROM route WHERE id = ?", new Object[] {route.getId()});
	}

	@Override
	public List<Route> extractData(ResultSet rs) throws SQLException {
		List<Route> routeList = new ArrayList<>();
		while (rs.next()) {
			Route route = new Route();
			route.setId(rs.getInt("id"));
			AirportDAO airportDAO = new AirportDAO(conn);
			route.setOrigin(airportDAO.readAirportById(rs.getString("origin_id")));
			route.setDestination(airportDAO.readAirportById(rs.getString("destination_id")));
			routeList.add(route);
		}
		return routeList;
	}
	
}
