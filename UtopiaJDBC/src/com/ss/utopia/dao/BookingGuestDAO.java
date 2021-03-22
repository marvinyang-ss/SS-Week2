/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.BookingGuest;

/**
 * @author marvin
 *
 */
public class BookingGuestDAO extends BaseDAO<BookingGuest> {
	
	public BookingGuestDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Read all bookingGuests
	 * @return
	 * @throws SQLException
	 */
	public List<BookingGuest> readAllBookingGuests() throws SQLException {
		return read("SELECT * FROM booking_guest", null);
	}
	
	/**
	 * Read bookingGuest with the given id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public BookingGuest readBookingGuestById(Integer bookingId) throws SQLException {
		return read("SELECT * FROM booking_guest WHERE booking_id = ?", new Object[] {bookingId}).get(0);
	}
	
	/**
	 * Add bookingGuest into database
	 * @param bookingGuest
	 * @throws SQLException
	 */
	public void addBookingGuest(BookingGuest bookingGuest) throws SQLException {
		save("INSERT INTO booking_guest VALUES (?, ?, ?)", 
			new Object[] {bookingGuest.getBooking().getId(), bookingGuest.getContactEmail(), bookingGuest.getContactPhone()});
	}
	
	/**
	 * Update bookingGuest in database
	 * @param bookingGuest
	 * @throws SQLException
	 */
	public void updateBookingGuest(BookingGuest bookingGuest) throws SQLException {
		save("UPDATE booking_guest SET contact_email = ?, contact_phone = ? WHERE booking_id = ?", 
			new Object[] {bookingGuest.getContactEmail(), bookingGuest.getContactPhone(), bookingGuest.getBooking().getId()});
	}
	
	/**
	 * Delete bookingGuest from database
	 * @param bookingGuest
	 * @throws SQLException
	 */
	public void deleteBookingGuest(BookingGuest bookingGuest) throws SQLException {
		save("DELETE FROM booking_guest WHERE booking_id = ?", new Object[] {bookingGuest.getBooking().getId()});
	}

	@Override
	public List<BookingGuest> extractData(ResultSet rs) throws SQLException {
		List<BookingGuest> bookingGuestList = new ArrayList<>();
		while (rs.next()) {
			BookingGuest bookingGuest = new BookingGuest();
			bookingGuest.setBooking(new BookingDAO(conn).readBookingById(rs.getInt("booking_id")));
			bookingGuest.setContactEmail("contact_email");
			bookingGuest.setContactPhone("contact_phone");
			bookingGuestList.add(bookingGuest);
		}
		return bookingGuestList;
	}
	
}
