package io.attil;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.attil.HanoiTower;

public class TestHanoiTower {

	
	@Test
	public void newHanoiTowerEmpty() {
		HanoiTower ht = new HanoiTower();
		assertTrue(ht.empty());
	}
}
