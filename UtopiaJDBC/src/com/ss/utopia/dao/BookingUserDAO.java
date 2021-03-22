/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.BookingUser;

/**
 * @author marvin
 *
 */
public class BookingUserDAO extends BaseDAO<BookingUser> {
	
	public BookingUserDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Read all bookingUsers
	 * @return
	 * @throws SQLException
	 */
	public List<BookingUser> readAllBookingUsers() throws SQLException {
		return read("SELECT * FROM booking_user", null);
	}
	
	/**
	 * Read bookingUser with the given id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public BookingUser readBookingUserById(Integer bookingId, Integer userId) throws SQLException {
		return read("SELECT * FROM booking_user WHERE booking_id = ? AND user_id = ?", new Object[] {bookingId, userId}).get(0);
	}
	
	/**
	 * Add bookingUser into database
	 * @param bookingUser
	 * @throws SQLException
	 */
	public void addBookingUser(BookingUser bookingUser) throws SQLException {
		save("INSERT INTO booking_user VALUES (?, ?)", new Object[] {bookingUser.getBooking().getId(), bookingUser.getUser().getId()});
	}
	
	/**
	 * Update bookingUser in database
	 * @param bookingUser
	 * @throws SQLException
	 */
	public void updateBookingUser(BookingUser oldBookingUser, BookingUser newBookingUser) throws SQLException {
		save("UPDATE booking_user SET booking_id = ?, user_id = ? "
			+ "WHERE booking_id = ? AND user_id = ?", 
			new Object[] {
				newBookingUser.getBooking().getId(),
				newBookingUser.getUser().getId(),
				oldBookingUser.getBooking().getId(),
				oldBookingUser.getUser().getId()
			}
		);
	}
	
	/**
	 * Delete bookingUser from database
	 * @param bookingUser
	 * @throws SQLException
	 */
	public void deleteBookingUser(BookingUser bookingUser) throws SQLException {
		save("DELETE FROM booking_user WHERE booking_id = ? AND user_id = ?", 
				new Object[] {bookingUser.getBooking().getId(), bookingUser.getUser().getId()});
	}

	@Override
	public List<BookingUser> extractData(ResultSet rs) throws SQLException {
		List<BookingUser> bookingUserList = new ArrayList<>();
		while (rs.next()) {
			BookingUser bookingUser = new BookingUser();
			bookingUser.setBooking(new BookingDAO(conn).readBookingById(rs.getInt("booking_id")));
			bookingUser.setUser(new UserDAO(conn).readUserById(rs.getInt("user_id")));
			bookingUserList.add(bookingUser);
		}
		return bookingUserList;
	}
	
}
