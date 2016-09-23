package com.fdmgroup.GameManagement;

import java.util.HashMap;
import java.util.Map;

import com.fdmgroup.Models.FDMafiaUser;

/**
 * 
 * @author Sahil Shah
 *
 */
public class Game 
{
	private Map<FDMafiaUser,GameStatus> players;
	
	public Game()
	{
		RoleAssigner.reset();
		players = new HashMap<FDMafiaUser,GameStatus>();
	}
	
	/**
	 * 
	 * @param newPlayer
	 * @return
	 */
	public void addPlayer(FDMafiaUser newPlayer)
	{
		if (!players.containsKey(newPlayer)){
			players.put(newPlayer, new GameStatus());
		}
	}

	/**
	 * Determines if Mafia Room is full
	 * @return 
	 */
	public boolean isFull()
	{
		return players.size() >= 5;
	}
	
	
	/**
	 * @return the players
	 */
	public Map<FDMafiaUser, GameStatus> getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(Map<FDMafiaUser, GameStatus> players) {
		this.players = players;
	}
	
	
}
