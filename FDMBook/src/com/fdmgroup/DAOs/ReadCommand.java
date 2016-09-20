package com.fdmgroup.DAOs;

import com.fdmgroup.Models.FDMafiaUser;

/**
 * 
 * @author kishan.patel1
 *
 */

public interface ReadCommand {
	/**
	 * 
	 * @param username - Username of user whose data will be retrieved from database.
	 * @return
	 */
	abstract FDMafiaUser readUser(String username);
}
