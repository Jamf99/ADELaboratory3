package model;

import java.io.Serializable;
import java.util.ArrayList;

import structures.RedBlackTree;

public class FIBA implements Serializable {
	
	private RedBlackTree<Comparable, Player> parent;
	
	public FIBA() {
		parent = new RedBlackTree<Comparable, Player>();
	}
	
	public void addPlayersByPoints(Player p) {
		parent.insert(p.getPointsPerMatch(), p);
	}
	
	public ArrayList<Player> getPlayers(){
		return parent.getElements();
	}


}
