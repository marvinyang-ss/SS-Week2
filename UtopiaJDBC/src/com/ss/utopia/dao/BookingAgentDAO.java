/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.BookingAgent;

/**
 * @author marvin
 *
 */
public class BookingAgentDAO extends BaseDAO<BookingAgent> {
	
	public BookingAgentDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Read all bookingAgents
	 * @return
	 * @throws SQLException
	 */
	public List<BookingAgent> readAllBookingAgents() throws SQLException {
		return read("SELECT * FROM booking_agent", null);
	}
	
	/**
	 * Read bookingAgent with the given id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public BookingAgent readBookingAgentById(Integer bookingId, Integer agentId) throws SQLException {
		List<BookingAgent> bookingAgents = read("SELECT * FROM booking_agent WHERE booking_id = ? AND agent_id = ?", new Object[] {bookingId, agentId});
		if (bookingAgents.size() == 0) {
			return null;
		}
		return bookingAgents.get(0);
	}
	
	/**
	 * Add bookingAgent into database
	 * @param bookingAgent
	 * @throws SQLException
	 */
	public void addBookingAgent(BookingAgent bookingAgent) throws SQLException {
		save("INSERT INTO booking_agent VALUES (?, ?)", new Object[] {bookingAgent.getBooking().getId(), bookingAgent.getAgent().getId()});
	}
	
	/**
	 * Update bookingAgent in database
	 * @param bookingAgent
	 * @throws SQLException
	 */
	public void updateBookingAgent(BookingAgent oldBookingAgent, BookingAgent newBookingAgent) throws SQLException {
		save("UPDATE booking_agent SET booking_id = ?, agent_id = ? "
			+ "WHERE booking_id = ? AND agent_id = ?", 
			new Object[] {
				newBookingAgent.getBooking().getId(),
				newBookingAgent.getAgent().getId(),
				oldBookingAgent.getBooking().getId(),
				oldBookingAgent.getAgent().getId()
			}
		);
	}
	
	/**
	 * Delete bookingAgent from database
	 * @param bookingAgent
	 * @throws SQLException
	 */
	public void deleteBookingAgent(BookingAgent bookingAgent) throws SQLException {
		save("DELETE FROM booking_agent WHERE booking_id = ? AND agent_id = ?", 
				new Object[] {bookingAgent.getBooking().getId(), bookingAgent.getAgent().getId()});
	}

	@Override
	public List<BookingAgent> extractData(ResultSet rs) throws SQLException {
		List<BookingAgent> bookingAgentList = new ArrayList<>();
		while (rs.next()) {
			BookingAgent bookingAgent = new BookingAgent();
			bookingAgent.setBooking(new BookingDAO(conn).readBookingById(rs.getInt("booking_id")));
			bookingAgent.setAgent(new UserDAO(conn).readUserById(rs.getInt("agent_id")));
			bookingAgentList.add(bookingAgent);
		}
		return bookingAgentList;
	}
	
}
