package com.fdmgroup.GameManagement;

/**
 * 
 * @author Sahil Shah
 *
 */
public class GameStatus 
{
	private GameRole gameRole;
	private boolean isAlive;
	
	public GameStatus()
	{
		isAlive = true;
		gameRole = RoleAssigner.assign();
	}
	/**
	 * @return the gameRole
	 */
	public GameRole getGameRole() {
		return gameRole;
	}
	/**
	 * @param gameRole the gameRole to set
	 */
	public void setGameRole(GameRole gameRole) {
		this.gameRole = gameRole;
	}
	/**
	 * @return the isAlive
	 */
	public boolean isAlive() {
		return isAlive;
	}
	/**
	 * @param isAlive the isAlive to set
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	
}
