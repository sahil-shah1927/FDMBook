package com.fdmgroup.DAOs;

import com.fdmgroup.Models.FDMBookUser;

/**
 * 
 * @author kishan.patel1
 *
 */
public interface WriteCommand {
	/**
	 * 
	 * @param user - User that is to be stored to some form of database.
	 */
	public void writeUser(FDMBookUser user);
}
