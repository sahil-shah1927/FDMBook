package com.fdmgroup.GameManagement;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 
 * @author Sahil Shah
 *
 */
public class RoleAssigner 
{
	private static Stack<GameRole> rolesAvailable;
	
	/**
	 * Assigns the next Role from rolesAvailable. If none are available,
	 * automatically assign Spectator Role.
	 * @return
	 */
	public static GameRole assign()
	{
		try
		{
			return rolesAvailable.pop();
		}
		catch(EmptyStackException e)
		{
			return GameRole.SPECTATOR;
		}
		
	}
	
	public static void reset()
	{
		rolesAvailable = new Stack<GameRole>();
		
		rolesAvailable.push(GameRole.MAFIA);
		rolesAvailable.push(GameRole.COP);
		rolesAvailable.push(GameRole.NURSE);
		rolesAvailable.push(GameRole.CIVILIAN);
		rolesAvailable.push(GameRole.SECOND_CIVILIAN);
		
		Collections.shuffle(rolesAvailable);
	}
}
