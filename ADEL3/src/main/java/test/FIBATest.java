package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;
import model.FIBA;
import model.Player;

public class FIBATest extends TestCase {
	
	private FIBA fiba;
	
	private void stage1() {
		fiba = new FIBA();
		fiba.addPlayerByPoints(new Player("Camilo Barrios", "ICESI", 28, 0, 0, 0, 0, 0));
	}
	
	@Test
	public void testaddPlayerByPoints() {
		stage1();
		assertNotNull(fiba.getPlayersPreorden().get(0));
	}
	
	private void stage2() {
		fiba = new FIBA();
		fiba.addPlayerByRebounds(new Player("Camilo Barrios", "ICESI", 28, 0, 0, 0, 0, 0));
	}
	
	@Test
	public void testaddPlayerByRebounds() {
		stage2();
		assertNotNull(fiba.getPlayersPreorden().get(0));
	}
	
	private void stage3() {
		fiba = new FIBA();
		fiba.addPlayerBySteals(new Player("Camilo Barrios", "ICESI", 28, 0, 0, 0, 0, 0));
	}
	
	@Test
	public void testaddPlayerBySteals() {
		stage3();
		assertNotNull(fiba.getPlayersPreorden().get(0));
	}
	
	private void stage4() {
		fiba = new FIBA();
		fiba.addPlayerByAssists(new Player("Camilo Barrios", "ICESI", 28, 0, 0, 0, 0, 0));
	}
	
	@Test
	public void testaddPlayerByAssists() {
		stage4();
		assertNotNull(fiba.searchPlayersAVL(0));
	}
	
	private void stage5() {
		fiba = new FIBA();
		fiba.addPlayerByBlocks(new Player("Camilo Barrios", "ICESI", 28, 0, 0, 0, 0, 0));
	}
	
	@Test
	public void testaddPlayerByBlocks() {
		stage5();
		assertNotNull(fiba.searchPlayersAVL(0));
	}
	
	private void stage6() {
		fiba = new FIBA();
		fiba.addPlayerByPoints(new Player("Camilo Barrios", "ICESI", 28, 0, 0, 0, 0, 0));
		fiba.addPlayerByPoints(new Player("Sarna", "ICESI", 28, 1, 1, 1, 1, 1));
		fiba.addPlayerByPoints(new Player("Reyes", "ICESI", 28, 2, 2, 2, 2, 2));
	}
	
	@Test
	public void testgetPlayersPreorden() {
		stage6();
		ArrayList players = fiba.getPlayersPreorden();
		boolean l1 = players.get(0).toString() == "Sarna" && players.get(1).toString() == "Camilo Barrios" && players.get(2).toString() == "Reyes";
		assertTrue(l1);
	}
	
	private void stage7() {
		fiba = new FIBA();
		fiba.addPlayerByPoints(new Player("Camilo Barrios", "ICESI", 28, 0, 0, 0, 0, 0));
		fiba.addPlayerByPoints(new Player("Sarna", "ICESI", 28, 1, 1, 1, 1, 1));
		fiba.addPlayerByPoints(new Player("Reyes", "ICESI", 28, 2, 2, 2, 2, 2));
	}
	
	@Test
	public void testsearchPlayersRB() {
		stage7();
		Player p1 = fiba.searchPlayersRB(1);
		assertEquals("Sarna", p1.getName());
	}
	
	private void stage8() {
		fiba = new FIBA();
		fiba.addPlayerByPoints(new Player("Camilo Barrios", "ICESI", 28, 0, 0, 0, 0, 0));
		fiba.addPlayerByPoints(new Player("Sarna", "ICESI", 28, 1, 1, 1, 1, 1));
		fiba.addPlayerByPoints(new Player("Reyes", "ICESI", 28, 2, 2, 2, 2, 2));
	}
	
	@Test
	public void testsearchPlayersAVL() {
		stage8();
		Player p1 = fiba.searchPlayersRB(1);
		assertEquals("Sarna", p1.getName());
	}
	
}
