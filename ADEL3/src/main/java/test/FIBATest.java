package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.FIBA;

public class FIBATest {
	
	private FIBA fiba;
	
	private void stage1() {
		fiba = new FIBA();
	}
	
	@Test
	public void testaddPlayerByPoints() {
		stage1();
		
	}
	
	private void stage2() {
		fiba = new FIBA();
	}
	
	@Test
	public void testaddPlayerByRebounds() {
		stage2();
		
	}
	
	private void stage3() {
		fiba = new FIBA();
	}
	
	@Test
	public void testaddPlayerBySteals() {
		stage3();
		
	}
	
	private void stage4() {
		fiba = new FIBA();
	}
	
	@Test
	public void testaddPlayerByAssists() {
		stage4();
	}
	
	private void stage5() {
		fiba = new FIBA();
	}
	
	@Test
	public void testaddPlayerByBlocks() {
		stage5();
	}
	
	private void stage6() {
		fiba = new FIBA();
	}
	
	@Test
	public void testagetPlayersPreorden() {
		stage6();
	}
	
	private void stage7() {
		fiba = new FIBA();
	}
	
	@Test
	public void testsearchPlayersRB() {
		stage7();
	}
	
	
	private void stage8() {
		fiba = new FIBA();
	}
	
	@Test
	public void testsearchPlayersAVL() {
		stage8();
	}
	
}
