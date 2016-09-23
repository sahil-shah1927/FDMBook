package com.fdmgroup.GameManagement;

import java.util.HashMap;

import com.fdmgroup.Models.FDMafiaUser;

public class TestGameDriver 
{
	public static void main(String[] args)
	{
		Game testGame = new Game();
		
		FDMafiaUser user1 = new FDMafiaUser();
			user1.setUsername("user1");
			
		FDMafiaUser user2 = new FDMafiaUser();
			user2.setUsername("user2");
		
		FDMafiaUser user3 = new FDMafiaUser();
			user3.setUsername("user3");
		
		FDMafiaUser user4 = new FDMafiaUser();
			user4.setUsername("user4");
		
		FDMafiaUser user5 = new FDMafiaUser();
			user5.setUsername("user5");
		
		FDMafiaUser user6 = new FDMafiaUser();
			user6.setUsername("user6");
			
			FDMafiaUser user7 = new FDMafiaUser();
			user7.setUsername("user7");
			
			FDMafiaUser user8 = new FDMafiaUser();
			user8.setUsername("user8");
			
			FDMafiaUser user9 = new FDMafiaUser();
			user9.setUsername("user9");
			
		testGame.addPlayer(user1);
		testGame.addPlayer(user2);
		testGame.addPlayer(user3);
		testGame.addPlayer(user4);
		testGame.addPlayer(user5);
		testGame.addPlayer(user6);
		testGame.addPlayer(user7);
		testGame.addPlayer(user8);
		testGame.addPlayer(user9);
		
		HashMap<FDMafiaUser,GameStatus> players = (HashMap<FDMafiaUser,GameStatus>)testGame.getPlayers();
	
		System.out.println(user1.getUsername() + ": " + players.get(user1).getGameRole());
		System.out.println(user2.getUsername() + ": " + players.get(user2).getGameRole());
		System.out.println(user3.getUsername() + ": " + players.get(user3).getGameRole());
		System.out.println(user4.getUsername() + ": " + players.get(user4).getGameRole());
		System.out.println(user5.getUsername() + ": " + players.get(user5).getGameRole());
		System.out.println(user6.getUsername() + ": " + players.get(user6).getGameRole());
		System.out.println(user7.getUsername() + ": " + players.get(user7).getGameRole());
		System.out.println(user8.getUsername() + ": " + players.get(user8).getGameRole());
		System.out.println(user9.getUsername() + ": " + players.get(user9).getGameRole());

	}
}
