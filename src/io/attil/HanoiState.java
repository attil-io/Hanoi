package io.attil;

public class HanoiState {
	private static int NUM_TOWERS = 3;
	private HanoiTower [] towers = new HanoiTower[NUM_TOWERS];
	
	public HanoiState(int diskNum) {
		for (int i = 0; i < NUM_TOWERS; ++i) {
			towers[i] = new HanoiTower();
		}
		for (int i = diskNum; i > 0; --i) {
			towers[0].push(i);
		}
	}
	
	public void moveDisk(int src, int dest) {
		towers[dest].push(towers[src].pop());
	}
	
	public int getTop(int column) {
		return towers[column].peek();
	}
	
	public boolean empty(int column) {
		return towers[column].empty();
	}

	public int findMinColumn() {
		if (allEmpty()) {
			throw new IllegalStateException("all columns are empty, cannot find minimum");
		}
		int minIdx = 0;
		for (int i = 0; i < NUM_TOWERS; ++i) {
			if (!towers[i].empty() && towers[i].peek() < towers[minIdx].peek()) {
				minIdx = i;
			}
		}
		return minIdx;
	}

	public int findMaxColumn() {
		if (allEmpty()) {
			throw new IllegalStateException("all columns are empty, cannot find maximum");
		}
		int maxIdx = 0;
		for (int i = 0; i < NUM_TOWERS; ++i) {
			if (!towers[i].empty() && towers[i].peek() > towers[maxIdx].peek()) {
				maxIdx = i;
			}
		}
		return maxIdx;
	}

	public int findEmptyColumn() {
		for (int i = 0; i < NUM_TOWERS; ++i) {
			if (towers[i].empty()) {
				return i;
			}
		}
		throw new IllegalStateException("no empty columns");
	}

	public boolean hasEmptyColumn() {
		return towers[0].empty() || towers[1].empty() || towers[2].empty();
	}
	
	private boolean allEmpty() {
		return towers[0].empty() && towers[1].empty() && towers[2].empty();
	}
}
