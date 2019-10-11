package com.udemy.generics;

public class Main {

	public static void main(String[] args) {
		FootballPlayer mike= new FootballPlayer("mike");
		FootballPlayer paul= new FootballPlayer("paul");
		
		Team<FootballPlayer> myTeam=new Team<>("warriors");

	}

}
