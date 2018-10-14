package model;

import java.io.Serializable;

public class Player implements Serializable{
	
	private String name;
	private String team;
	private int age;
	
	private double pointsPerMatch;
	private double reboundsPerMatch;
	private double assistsPerMatch;
	private double stealingPerMatch;
	private double blocksPerMatch;
	
	public Player(String name, String team, int age, double pointsPerMatch, double reboundsPerMatch,
			double assistsPerMatch, double stealingPerMatch, double blocksPerMatch) {
		this.name = name;
		this.team = team;
		this.age = age;
		this.pointsPerMatch = pointsPerMatch;
		this.reboundsPerMatch = reboundsPerMatch;
		this.assistsPerMatch = assistsPerMatch;
		this.stealingPerMatch = stealingPerMatch;
		this.blocksPerMatch = blocksPerMatch;
	}

	public String getName() {
		return name;
	}

	public String getTeam() {
		return team;
	}

	public int getAge() {
		return age;
	}

	public double getPointsPerMatch() {
		return pointsPerMatch;
	}

	public double getReboundsPerMatch() {
		return reboundsPerMatch;
	}

	public double getAssistsPerMatch() {
		return assistsPerMatch;
	}

	public double getStealingPerMatch() {
		return stealingPerMatch;
	}

	public double getBlocksPerMatch() {
		return blocksPerMatch;
	}
	
	public String toString() {
		return name;
	}

}
