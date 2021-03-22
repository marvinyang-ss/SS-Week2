/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.User;

/**
 * @author marvin
 *
 */
public class UserDAO extends BaseDAO<User> {
	
	public UserDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Read all users
	 * @return
	 * @throws SQLException
	 */
	public List<User> readAllUsers() throws SQLException {
		return read("SELECT * FROM user", null);
	}
	
	/**
	 * Read user with the given id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public User readUserById(Integer id) throws SQLException {
		List<User> result = read("SELECT * FROM user WHERE id = ?", new Object[] {id});
		if (result.size() == 0) {
			return null;
		}
		return result.get(0);
	}
	
	/**
	 * Read user with the given username and password
	 * @return
	 * @throws SQLException
	 */
	public User readUserByLogin(String username, String password) throws SQLException {
		List<User> result = read("SELECT * FROM user WHERE username = ? AND password = ?", new Object[] {username, password});
		if (result.size() == 0) {
			return null;
		}
		return result.get(0);
	}
	
	/**
	 * Add user into database
	 * @param user
	 * @throws SQLException
	 */
	public void addUser(User user) throws SQLException {
		save("INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?, ?)", 
			new Object[] {
				user.getId(),
				user.getRole().getId(),
				user.getGivenName(),
				user.getFamilyName(),
				user.getUsername(),
				user.getEmail(),
				user.getPassword(),
				user.getPhone()
			}
		);
	}
	
	/**
	 * Update user in database
	 * @param user
	 * @throws SQLException
	 */
	public void updateUser(User user) throws SQLException {
		save("UPDATE user SET "
				+ "role_id = ?, "
				+ "given_name = ?, "
				+ "family_name = ?, "
				+ "username = ?, "
				+ "email = ?, "
				+ "password = ?, "
				+ "phone = ? "
				+ "WHERE id = ?", 
			new Object[] {
				user.getRole().getId(),
				user.getGivenName(),
				user.getFamilyName(),
				user.getUsername(),
				user.getEmail(),
				user.getPassword(),
				user.getPhone(),
				user.getId()
			}
		);
	}
	
	/**
	 * Delete user from database
	 * @param user
	 * @throws SQLException
	 */
	public void deleteUser(User user) throws SQLException {
		save("DELETE FROM user WHERE id = ?", new Object[] {user.getId()});
	}

	@Override
	public List<User> extractData(ResultSet rs) throws SQLException {
		List<User> userList = new ArrayList<>();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setRole(new UserRoleDAO(conn).readUserRoleById(rs.getInt("role_id")));
			user.setGivenName(rs.getString("given_name"));
			user.setFamilyName(rs.getString("family_name"));
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			userList.add(user);
		}
		return userList;
	}
	
}
