package com.modjam.hytalemoddingjam.gameLogic;

public class EndedGameData {

	private int lastWave;
	private int totalScrap;
	private int totalDeath;
	private boolean won;

	public int getLastWave() {
		return lastWave;
	}

	public EndedGameData setLastWave(int lastWave) {
		this.lastWave = lastWave;
		return this;
	}

	public int getTotalScrap() {
		return totalScrap;
	}

	public EndedGameData setTotalScrap(int totalScrap) {
		this.totalScrap = totalScrap;
		return this;
	}

	public int getTotalDeath() {
		return totalDeath;
	}

	public EndedGameData setTotalDeath(int totalDeath) {
		this.totalDeath = totalDeath;
		return this;
	}

	public boolean isWon() {
		return won;
	}

	public EndedGameData setWon(boolean won) {
		this.won = won;
		return this;
	}
}
