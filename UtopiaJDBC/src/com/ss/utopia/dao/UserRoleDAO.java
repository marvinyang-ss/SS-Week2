/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.UserRole;

/**
 * @author marvin
 *
 */
public class UserRoleDAO extends BaseDAO<UserRole> {
	
	public UserRoleDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Read all userRoles
	 * @return
	 * @throws SQLException
	 */
	public List<UserRole> readAllUserRoles() throws SQLException {
		return read("SELECT * FROM user_role", null);
	}
	
	/**
	 * Read userRole with the given id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public UserRole readUserRoleById(Integer id) throws SQLException {
		return read("SELECT * FROM user_role WHERE id = ?", new Object[] {id}).get(0);
	}
	
	/**
	 * Read userRole with the given name
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public UserRole readUserRoleByName(String name) throws SQLException {
		return read("SELECT * FROM user_role WHERE name = ?", new Object[] {name}).get(0);
	}
	
	/**
	 * Add userRole into database
	 * @param userRole
	 * @throws SQLException
	 */
	public void addUserRole(UserRole userRole) throws SQLException {
		save("INSERT INTO user_role VALUES (?, ?)", new Object[] {userRole.getId(), userRole.getName()});
	}
	
	/**
	 * Update userRole in database
	 * @param userRole
	 * @throws SQLException
	 */
	public void updateUserRole(UserRole userRole) throws SQLException {
		save("UPDATE user_role SET name = ? WHERE id = ?", new Object[] {userRole.getName(), userRole.getId()});
	}
	
	/**
	 * Delete userRole from database
	 * @param userRole
	 * @throws SQLException
	 */
	public void deleteUserRole(UserRole userRole) throws SQLException {
		save("DELETE FROM user_role WHERE id = ?", new Object[] {userRole.getId()});
	}

	@Override
	public List<UserRole> extractData(ResultSet rs) throws SQLException {
		List<UserRole> userRoleList = new ArrayList<>();
		while (rs.next()) {
			UserRole userRole = new UserRole();
			userRole.setId(rs.getInt("id"));
			userRole.setName(rs.getString("name"));
			userRoleList.add(userRole);
		}
		return userRoleList;
	}
	
}
