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

	
	@Test
	public void findMinColumnAllEmpty() {
		HanoiState state = new HanoiState(0);
		try {
			state.findMinColumn();
			fail("IllegalStateException expected");
		}
		catch (IllegalStateException e) {
			// that's what we want
		}
	}

	@Test
	public void findMinColumn() {
		HanoiState state = new HanoiState(1);
		assertEquals(0, state.findMinColumn());
	}

	@Test
	public void findMaxColumnAllEmpty() {
		HanoiState state = new HanoiState(0);
		try {
			state.findMaxColumn();
			fail("IllegalStateException expected");
		}
		catch (IllegalStateException e) {
			// that's what we want
		}
	}

	@Test
	public void findMaxColumn() {
		HanoiState state = new HanoiState(1);
		assertEquals(0, state.findMaxColumn());
	}

	@Test
	public void findEmptyAllEmpty() {
		HanoiState state = new HanoiState(0);
		assertEquals(0, state.findEmptyColumn());
	}

	@Test
	public void findEmptyNoneEmpty() {
		HanoiState state = new HanoiState(3);
		state.moveDisk(0, 1);
		state.moveDisk(0, 2);
		try {
			state.findEmptyColumn();
			fail("IllegalStateException expected");
		}
		catch (IllegalStateException e) {
			// that's what we want
		}		
	}
	
	@Test
	public void findEmptyColumn() {
		HanoiState state = new HanoiState(1);
		assertEquals(1, state.findEmptyColumn());
	}

	@Test
	public void hasEmptyColumnAllEmpty() {
		HanoiState state = new HanoiState(0);
		assertTrue(state.hasEmptyColumn());
	}

	@Test
	public void hasEmptyColumnSomeEmpty() {
		HanoiState state = new HanoiState(1);
		assertTrue(state.hasEmptyColumn());
	}

	@Test
	public void hasEmptyColumnNoneEmpty() {
		HanoiState state = new HanoiState(3);
		state.moveDisk(0, 1);
		state.moveDisk(0, 2);
		assertFalse(state.hasEmptyColumn());
	}

}
