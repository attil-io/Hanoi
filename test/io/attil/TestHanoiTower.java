package io.attil;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.EmptyStackException;

import org.junit.Test;

public class TestHanoiTower {
	
	@Test
	public void newHanoiTowerEmpty() {
		HanoiTower ht = new HanoiTower();
		assertTrue(ht.empty());
	}

	@Test
	public void noPopFromEmpty() {
		HanoiTower ht = new HanoiTower();
		try {
			ht.pop();
			fail("EmptyStackException expected");
		}
		catch (EmptyStackException e) {
			// that's what we want
		}
	}	

	@Test
	public void noPeekFromEmpty() {
		HanoiTower ht = new HanoiTower();
		try {
			ht.peek();
			fail("EmptyStackException expected");
		}
		catch (EmptyStackException e) {
			// that's what we want
		}
	}		
	
	@Test
	public void pushPop() {
		HanoiTower ht = new HanoiTower();
		ht.push(1);
		assertEquals(1, ht.pop());
	}

	@Test
	public void pushPeek() {
		HanoiTower ht = new HanoiTower();
		ht.push(1);
		assertEquals(1, ht.peek());
	}	
	
	@Test
	public void pushPopOrder() {
		HanoiTower ht = new HanoiTower();
		ht.push(5);
		ht.push(4);
		ht.push(3);
		ht.push(2);
		ht.push(1);
		assertEquals(1, ht.pop());
		assertEquals(2, ht.pop());
		assertEquals(3, ht.pop());
		assertEquals(4, ht.pop());
		assertEquals(5, ht.pop());
	}
	
	@Test
	public void pushOverSmaller() {
		HanoiTower ht = new HanoiTower();
		ht.push(1);
		try {
			ht.push(2);
			fail("IllegalArgumentException expected");
		}
		catch (IllegalArgumentException iae) {
			// that's what we want
		}
	}

	@Test
	public void pushOverEqual() {
		HanoiTower ht = new HanoiTower();
		ht.push(1);
		try {
			ht.push(1);
			fail("IllegalArgumentException expected");
		}
		catch (IllegalArgumentException iae) {
			// that's what we want
		}
	}
}
