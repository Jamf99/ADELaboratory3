package model;

import java.io.Serializable;
import java.util.ArrayList;

import structures.AVLTree;
import structures.RedBlackTree;

public class FIBA implements Serializable {
	
	private RedBlackTree<Comparable, Player> parentRB;
	private AVLTree<Comparable, Player> parentAVL;
	
	public FIBA() {
		parentRB = new RedBlackTree<Comparable, Player>();
	}
	
	public void addPlayerByPoints(Player p) {
		parentRB.insert(p.getPointsPerMatch(), p);
	}
	
	public void addPlayerByRebounds(Player p) {
		parentRB.insert(p.getPointsPerMatch(), p);
	}
	
	public void addPlayerBySteals(Player p) {
		parentRB.insert(p.getPointsPerMatch(), p);
	}
	
	public void addPlayerByAssists(Player p) {
		parentAVL.insert(p.getPointsPerMatch(), p);
	}
	
	public void addPlayerByBlocks(Player p) {
		parentAVL.insert(p.getPointsPerMatch(), p);
	}
	
	public ArrayList<Player> getPlayersPreorden(){
		return parentRB.getElements();
	}
	
	
	
}
