package com.fdmgroup.DAOs;

import com.fdmgroup.Models.FDMBookUser;

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
	abstract FDMBookUser readUser(String username);
}
