/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.BookingPayment;

/**
 * @author marvin
 *
 */
public class BookingPaymentDAO extends BaseDAO<BookingPayment> {
	
	public BookingPaymentDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Read all bookingPayments
	 * @return
	 * @throws SQLException
	 */
	public List<BookingPayment> readAllBookingPayments() throws SQLException {
		return read("SELECT * FROM booking_payment", null);
	}
	
	/**
	 * Read bookingPayment with the given id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public BookingPayment readBookingPaymentById(Integer bookingId) throws SQLException {
		return read("SELECT * FROM booking_payment WHERE booking_id = ?", new Object[] {bookingId}).get(0);
	}
	
	/**
	 * Add bookingPayment into database
	 * @param bookingPayment
	 * @throws SQLException
	 */
	public void addBookingPayment(BookingPayment bookingPayment) throws SQLException {
		save("INSERT INTO booking_payment VALUES (?, ?, ?)", 
			new Object[] {bookingPayment.getBooking().getId(), bookingPayment.getStripe(), bookingPayment.getRefunded()});
	}
	
	/**
	 * Update bookingPayment in database
	 * @param bookingPayment
	 * @throws SQLException
	 */
	public void updateBookingPayment(BookingPayment bookingPayment) throws SQLException {
		save("UPDATE booking_payment SET stripe_id = ?, refunded = ? WHERE booking_id = ?", 
			new Object[] {bookingPayment.getStripe(), bookingPayment.getRefunded(), bookingPayment.getBooking().getId()});
	}
	
	/**
	 * Delete bookingPayment from database
	 * @param bookingPayment
	 * @throws SQLException
	 */
	public void deleteBookingPayment(BookingPayment bookingPayment) throws SQLException {
		save("DELETE FROM booking_payment WHERE booking_id = ?", 
				new Object[] {bookingPayment.getBooking().getId()});
	}

	@Override
	public List<BookingPayment> extractData(ResultSet rs) throws SQLException {
		List<BookingPayment> bookingPaymentList = new ArrayList<>();
		while (rs.next()) {
			BookingPayment bookingPayment = new BookingPayment();
			bookingPayment.setBooking(new BookingDAO(conn).readBookingById(rs.getInt("booking_id")));
			bookingPayment.setStripe(rs.getString("stripe_id"));
			bookingPayment.setRefunded(rs.getBoolean("refunded"));
			bookingPaymentList.add(bookingPayment);
		}
		return bookingPaymentList;
	}
	
}
