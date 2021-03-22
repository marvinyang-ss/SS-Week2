/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.FlightBookings;

/**
 * @author marvin
 *
 */
public class FlightBookingsDAO extends BaseDAO<FlightBookings> {
	
	public FlightBookingsDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Read all flightBookingss
	 * @return
	 * @throws SQLException
	 */
	public List<FlightBookings> readAllFlightBookings() throws SQLException {
		return read("SELECT * FROM flight_bookings", null);
	}
	
	/**
	 * Read flightBookings with the given id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public FlightBookings readFlightBookingsById(Integer flightId, Integer bookingId) throws SQLException {
		List<FlightBookings> flightBookings = read("SELECT * FROM flight_bookings WHERE flight_id = ? AND booking_id = ?", new Object[] {flightId, bookingId});
		if (flightBookings.size() == 0) {
			return null;
		}
		return flightBookings.get(0);
	}
	
	/**
	 * Add flightBookings into database
	 * @param flightBookings
	 * @throws SQLException
	 */
	public void addFlightBookings(FlightBookings flightBookings) throws SQLException {
		save("INSERT INTO flight_bookings VALUES (?, ?)", new Object[] {flightBookings.getFlight().getId(), flightBookings.getBooking().getId()});
	}
	
	/**
	 * Update flightBookings in database
	 * @param flightBookings
	 * @throws SQLException
	 */
	public void updateFlightBookings(FlightBookings oldFlightBookings, FlightBookings newFlightBookings) throws SQLException {
		save("UPDATE flight_bookings SET flight_id = ?, booking_id = ? "
			+ "WHERE flight_id = ? AND booking_id = ?", 
			new Object[] {
				newFlightBookings.getFlight().getId(),
				newFlightBookings.getBooking().getId(),
				oldFlightBookings.getFlight().getId(),
				oldFlightBookings.getBooking().getId()
			}
		);
	}
	
	/**
	 * Delete flightBookings from database
	 * @param flightBookings
	 * @throws SQLException
	 */
	public void deleteFlightBookings(FlightBookings flightBookings) throws SQLException {
		save("DELETE FROM flight_bookings WHERE flight_id = ? AND booking_id = ?", 
				new Object[] {flightBookings.getFlight().getId(), flightBookings.getBooking().getId()});
	}

	@Override
	public List<FlightBookings> extractData(ResultSet rs) throws SQLException {
		List<FlightBookings> flightBookingsList = new ArrayList<>();
		while (rs.next()) {
			FlightBookings flightBookings = new FlightBookings();
			flightBookings.setFlight(new FlightDAO(conn).readFlightById(rs.getInt("flight_id")));
			flightBookings.setBooking(new BookingDAO(conn).readBookingById(rs.getInt("booking_id")));
			flightBookingsList.add(flightBookings);
		}
		return flightBookingsList;
	}
	
}
