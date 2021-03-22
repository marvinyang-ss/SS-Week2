/**
 * 
 */
package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.utopia.dao.BookingDAO;
import com.ss.utopia.dao.BookingUserDAO;
import com.ss.utopia.dao.FlightBookingsDAO;
import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.dao.UserDAO;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.BookingUser;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.FlightBookings;
import com.ss.utopia.entity.User;

/**
 * @author marvin
 *
 */
public class TravelerService {

	Util util = new Util();
	
	public User readUserByLogin(String username, String password) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			UserDAO userDAO = new UserDAO(conn);
			return userDAO.readUserByLogin(username, password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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
	
	public Integer addBooking(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookingDAO bookingDAO = new BookingDAO(conn);
			Integer key = bookingDAO.addBooking(booking);
			conn.commit();
			return key;
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return null;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public String addFlightBookings(FlightBookings flightBookings) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			FlightBookingsDAO flightBookingsDAO = new FlightBookingsDAO(conn);
			flightBookingsDAO.addFlightBookings(flightBookings);
			conn.commit();
			return "Successfully added flightBookings";
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Failed to add flightBookings";
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public String addBookingUser(BookingUser bookingUser) throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookingUserDAO bookingUserDAO = new BookingUserDAO(conn);
			bookingUserDAO.addBookingUser(bookingUser);
			conn.commit();
			return "Successfully added bookingUser";
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Failed to add bookingUser";
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public List<BookingUser> readAllBookingUsers() throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			BookingUserDAO bookingUserDAO = new BookingUserDAO(conn);
			return bookingUserDAO.readAllBookingUsers();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public List<FlightBookings> readAllFlightBookings() throws SQLException {
		Connection conn = null;
		try {
			conn = util.getConnection();
			FlightBookingsDAO flightBookingsDAO = new FlightBookingsDAO(conn);
			return flightBookingsDAO.readAllFlightBookings();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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
}
