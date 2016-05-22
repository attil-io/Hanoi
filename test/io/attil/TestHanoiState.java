package io.attil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.EmptyStackException;

import org.junit.Test;

public class TestHanoiState {

	@Test
	public void testEmptyStateGetTop() {
		HanoiState state = new HanoiState(0);
		try {
			int res = state.getTop(0);
			fail("EmptyStackException expected");
		}
		catch (EmptyStackException e) {
			// that's what we want
		}
	}

	@Test
	public void testEmptyStateEmpty() {
		HanoiState state = new HanoiState(0);
		assertTrue(state.empty(0));
	}
	
	
	@Test
	public void testOneElementState() {
		HanoiState state = new HanoiState(1);
		assertEquals(1, state.getTop(0));
	}

	@Test
	public void testOneElementStateNotEmpty() {
		HanoiState state = new HanoiState(1);
		assertFalse(state.empty(0));
	}
	
	@Test
	public void testMoveElement() {
		HanoiState state = new HanoiState(1);
		state.moveDisk(0, 1);
		assertEquals(1, state.getTop(1));
	}
}
