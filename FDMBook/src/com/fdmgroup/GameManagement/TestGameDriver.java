package com.fdmgroup.GameManagement;

import java.util.HashMap;

import com.fdmgroup.Models.FDMafiaUser;

public class TestGameDriver 
{
	public static void main()
	{
		Game testGame = new Game();
		
		FDMafiaUser user1 = new FDMafiaUser();
			user1.setUsername("user1");
			
		FDMafiaUser user2 = new FDMafiaUser();
			user1.setUsername("user2");
		
		FDMafiaUser user3 = new FDMafiaUser();
			user1.setUsername("user3");
		
		FDMafiaUser user4 = new FDMafiaUser();
			user1.setUsername("user4");
		
		FDMafiaUser user5 = new FDMafiaUser();
			user1.setUsername("user5");
		
		FDMafiaUser user6 = new FDMafiaUser();
			user1.setUsername("user6");
			
		testGame.addPlayer(user1);
		testGame.addPlayer(user2);
		testGame.addPlayer(user3);
		testGame.addPlayer(user4);
		testGame.addPlayer(user5);
		testGame.addPlayer(user6);
		
		HashMap<FDMafiaUser,GameStatus> players = (HashMap<FDMafiaUser,GameStatus>)testGame.getPlayers();
	
		System.out.println(user1.getUsername() + ": " + players.get(user1).getGameRole());
		System.out.println(user2.getUsername() + ": " + players.get(user2).getGameRole());
		System.out.println(user3.getUsername() + ": " + players.get(user3).getGameRole());
		System.out.println(user4.getUsername() + ": " + players.get(user4).getGameRole());
		System.out.println(user5.getUsername() + ": " + players.get(user5).getGameRole());
		System.out.println(user6.getUsername() + ": " + players.get(user6).getGameRole());

	}
}
