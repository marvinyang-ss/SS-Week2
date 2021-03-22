/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Passenger;

/**
 * @author marvin
 *
 */
public class PassengerDAO extends BaseDAO<Passenger> {
	
	public PassengerDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Read all passengers
	 * @return
	 * @throws SQLException
	 */
	public List<Passenger> readAllPassengers() throws SQLException {
		return read("SELECT * FROM passenger", null);
	}
	
	/**
	 * Read passenger with the given id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Passenger readPassengerById(Integer id) throws SQLException {
		List<Passenger> passengers = read("SELECT * FROM passenger WHERE id = ?", new Object[] {id});
		if (passengers.size() == 0) {
			return null;
		}
		return passengers.get(0);
	}
	
	/**
	 * Add passenger into database
	 * @param passenger
	 * @throws SQLException
	 */
	public void addPassenger(Passenger passenger) throws SQLException {
		save("INSERT INTO passenger VALUES (?, ?, ?, ?, ?, ?, ?)", 
			new Object[] {
				passenger.getId(), 
				passenger.getBooking().getId(),
				passenger.getGivenName(),
				passenger.getFamilyName(),
				passenger.getDateOfBirth(),
				passenger.getGender(),
				passenger.getAddress()
			}
		);
	}
	
	/**
	 * Update passenger in database
	 * @param passenger
	 * @throws SQLException
	 */
	public void updatePassenger(Passenger passenger) throws SQLException {
		save("UPDATE passenger SET "
				+ "booking_id = ?, "
				+ "given_name = ?, "
				+ "family_name = ?, "
				+ "dob = ?, "
				+ "gender = ?, "
				+ "address = ? "
				+ "WHERE id = ?", 
			new Object[] {
				passenger.getBooking().getId(),
				passenger.getGivenName(),
				passenger.getFamilyName(),
				passenger.getDateOfBirth(),
				passenger.getGender(),
				passenger.getAddress(),
				passenger.getId()
			}
		);
	}
	
	/**
	 * Delete passenger from database
	 * @param passenger
	 * @throws SQLException
	 */
	public void deletePassenger(Passenger passenger) throws SQLException {
		save("DELETE FROM passenger WHERE id = ?", new Object[] {passenger.getId()});
	}

	@Override
	public List<Passenger> extractData(ResultSet rs) throws SQLException {
		List<Passenger> passengerList = new ArrayList<>();
		while (rs.next()) {
			Passenger passenger = new Passenger();
			passenger.setId(rs.getInt("id"));
			passenger.setBooking(new BookingDAO(conn).readBookingById(rs.getInt("booking_id")));
			passenger.setGivenName(rs.getString("given_name"));
			passenger.setFamilyName(rs.getString("family_name"));
			passenger.setDateOfBirth(rs.getObject("dob", LocalDate.class));
			passenger.setGender(rs.getString("gender"));
			passenger.setAddress(rs.getString("address"));
			passengerList.add(passenger);
		}
		return passengerList;
	}
	
}
