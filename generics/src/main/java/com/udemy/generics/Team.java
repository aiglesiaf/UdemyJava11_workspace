package com.udemy.generics;

import java.util.List;

public class Team<T extends Player> {
	
	private String name;
	private List<T> players;
	
	public Team(String name) {
		super();
		this.name = name;
	}
	
	public void addPlayer(T player)
	{
		players.add(player);
	}
	
	
	
	

}
