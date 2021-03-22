/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Booking;

/**
 * @author marvin
 *
 */
public class BookingDAO extends BaseDAO<Booking> {
	
	public BookingDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Read all bookings
	 * @return
	 * @throws SQLException
	 */
	public List<Booking> readAllBookings() throws SQLException {
		return read("SELECT * FROM booking", null);
	}
	
	/**
	 * Read booking with the given id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Booking readBookingById(Integer id) throws SQLException {
		List<Booking> bookings = read("SELECT * FROM booking WHERE id = ?", new Object[] {id});
		if (bookings.size() == 0) {
			return null;
		}
		return bookings.get(0);
	}
	
	/**
	 * Add booking into database
	 * @param booking
	 * @throws SQLException
	 */
	public Integer addBooking(Booking booking) throws SQLException {
		return save("INSERT INTO booking VALUES (?, ?, ?)", 
			new Object[] {booking.getId(), booking.getIsActive(), booking.getConfirmationCode()});
	}
	
	/**
	 * Update booking in database
	 * @param booking
	 * @throws SQLException
	 */
	public void updateBooking(Booking booking) throws SQLException {
		save("UPDATE booking SET is_active = ?, confirmation_code = ? WHERE id = ?", 
			new Object[] {booking.getIsActive(), booking.getConfirmationCode(), booking.getId()});
	}
	
	/**
	 * Delete booking from database
	 * @param booking
	 * @throws SQLException
	 */
	public void deleteBooking(Booking booking) throws SQLException {
		save("DELETE FROM booking WHERE id = ?", new Object[] {booking.getId()});
	}

	@Override
	public List<Booking> extractData(ResultSet rs) throws SQLException {
		List<Booking> bookingList = new ArrayList<>();
		while (rs.next()) {
			Booking booking = new Booking();
			booking.setId(rs.getInt("id"));
			booking.setIsActive(rs.getBoolean("is_active"));
			booking.setConfirmationCode(rs.getString("confirmation_code"));
			bookingList.add(booking);
		}
		return bookingList;
	}
	
}
