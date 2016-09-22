package com.fdmgroup.GameManagement;

/**
 * 
 * @author Sahil Shah
 *
 */
public enum GameRole 
{
	MAFIA,COP,NURSE,CIVILIAN,SECOND_CIVILIAN,SPECTATOR;
	
	@Override
	public String toString() 
	{
		String str = super.toString();
		return str.substring(0, 1) + str.substring(1).toLowerCase();
	}
}
