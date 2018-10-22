package test;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;
import model.Player;

public class PlayerTest extends TestCase {
	
	private Player player;
	
	private void stage1() {
		player = new Player("Camilo Barrios", "ICESI", 28, 0, 0, 0, 0, 0);
	}
	
	@Test
	public void testgetName() {
		stage1();
		assertEquals("Camilo Barrios", player.getName());
	}
	
	@Test
	public void testgetTeam() {
		stage1();
		assertEquals("ICESI", player.getTeam());
	}
	
	@Test
	public void testgetAge() {
		stage1();
		assertEquals(28, player.getAge());
	}
	
	@Test
	public void testgetPointsPerMatch() {
		stage1();
		assertEquals(0.0, player.getPointsPerMatch());
	}
	
	@Test
	public void testgetReboundsPerMatch() {
		stage1();
		assertEquals(0.0, player.getReboundsPerMatch());
	}
	
	@Test
	public void testgetAssistsPerMatch() {
		stage1();
		assertEquals(0.0, player.getAssistsPerMatch());
	}
	
	@Test
	public void testgetStealingPerMatch() {
		stage1();
		assertEquals(0.0, player.getStealingPerMatch());
	}
	
	@Test
	public void testgetBlocksPerMatch() {
		stage1();
		assertEquals(0.0, player.getBlocksPerMatch());
	}
	
	@Test
	public void testtoString() {
		stage1();
		assertEquals("Camilo Barrios", player.toString());
	}
	
}
