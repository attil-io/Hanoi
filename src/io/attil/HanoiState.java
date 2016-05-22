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
}
