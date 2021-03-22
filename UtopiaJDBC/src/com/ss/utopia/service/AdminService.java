/**
 * 
 */
package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.utopia.dao.*;
import com.ss.utopia.entity.*;

/**
 * @author marvin
 *
 */
public class AdminService {
	
	Util util = new Util();
	
	public List<Airport> readAllAirports() throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			AirportDAO airportDAO = new AirportDAO(conn);
			return airportDAO.readAllAirports();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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
	
	public String addAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			AirportDAO airportDAO = new AirportDAO(conn);
			airportDAO.addAirport(airport);
			conn.commit();
			return "Successfully added airport";
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Failed to add airport";
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public String updateAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			AirportDAO airportDAO = new AirportDAO(conn);
			airportDAO.updateAirport(airport);
			conn.commit();
			return "Successfully updated airport";
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Failed to update airport";
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public String deleteAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			AirportDAO airportDAO = new AirportDAO(conn);
			airportDAO.deleteAirport(airport);
			conn.commit();
			return "Successfully deleted airport";
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Failed to delete airport";
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
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
	
	public Flight readFlight(Integer id) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			FlightDAO flightDAO = new FlightDAO(conn);
			return flightDAO.readFlightById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public String addFlight(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			FlightDAO flightDAO = new FlightDAO(conn);
			flightDAO.addFlight(flight);
			conn.commit();
			return "Successfully added flight";
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Failed to add flight";
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
	
	public String deleteFlight(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			FlightDAO flightDAO = new FlightDAO(conn);
			flightDAO.deleteFlight(flight);
			conn.commit();
			return "Successfully deleted flight";
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Failed to delete flight";
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public List<Booking> readAllBookings() throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookingDAO bookingDAO = new BookingDAO(conn);
			return bookingDAO.readAllBookings();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public Booking readBooking(Integer id) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookingDAO bookingDAO = new BookingDAO(conn);
			return bookingDAO.readBookingById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public String addBooking(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookingDAO bookingDAO = new BookingDAO(conn);
			bookingDAO.addBooking(booking);
			conn.commit();
			return "Successfully added booking";
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Failed to add booking";
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public String updateBooking(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookingDAO bookingDAO = new BookingDAO(conn);
			bookingDAO.updateBooking(booking);
			conn.commit();
			return "Successfully updated booking";
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Failed to update booking";
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public String deleteBooking(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookingDAO bookingDAO = new BookingDAO(conn);
			bookingDAO.deleteBooking(booking);
			conn.commit();
			return "Successfully deleted booking";
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Failed to delete booking";
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public List<Passenger> readAllPassengers() throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			PassengerDAO passengerDAO = new PassengerDAO(conn);
			return passengerDAO.readAllPassengers();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public Passenger readPassenger(Integer id) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			PassengerDAO passengerDAO = new PassengerDAO(conn);
			return passengerDAO.readPassengerById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public String addPassenger(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			PassengerDAO passengerDAO = new PassengerDAO(conn);
			passengerDAO.addPassenger(passenger);
			conn.commit();
			return "Successfully added passenger";
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Failed to add passenger";
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public String updatePassenger(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			PassengerDAO passengerDAO = new PassengerDAO(conn);
			passengerDAO.updatePassenger(passenger);
			conn.commit();
			return "Successfully updated passenger";
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Failed to update passenger";
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public String deletePassenger(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			PassengerDAO passengerDAO = new PassengerDAO(conn);
			passengerDAO.deletePassenger(passenger);
			conn.commit();
			return "Successfully deleted passenger";
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Failed to delete passenger";
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public List<User> readAllUsers() throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			UserDAO userDAO = new UserDAO(conn);
			return userDAO.readAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public User readUser(Integer id) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			UserDAO userDAO = new UserDAO(conn);
			return userDAO.readUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public String addUser(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			UserDAO userDAO = new UserDAO(conn);
			userDAO.addUser(user);
			conn.commit();
			return "Successfully added user";
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Failed to add user";
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public String updateUser(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			UserDAO userDAO = new UserDAO(conn);
			userDAO.updateUser(user);
			conn.commit();
			return "Successfully updated user";
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Failed to update user";
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public String deleteUser(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			UserDAO userDAO = new UserDAO(conn);
			userDAO.deleteUser(user);
			conn.commit();
			return "Successfully deleted user";
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Failed to delete user";
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
	
	public List<Airplane> readAllAirplanes() throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			AirplaneDAO airplaneDAO = new AirplaneDAO(conn);
			return airplaneDAO.readAllAirplanes();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public UserRole readUserRole(Integer id) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			UserRoleDAO userRoleDAO = new UserRoleDAO(conn);
			return userRoleDAO.readUserRoleById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public UserRole readUserRole(String name) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			UserRoleDAO userRoleDAO = new UserRoleDAO(conn);
			return userRoleDAO.readUserRoleByName(name);
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
