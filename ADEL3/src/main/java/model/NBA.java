package model;

public class NBA {
	
	private Player firstPlayer;
	private int size;
	
	public NBA() {
		this.size = 0;
	}

	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}
	
	public int getSize() {
		return size;
	}
	
}
