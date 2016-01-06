package com.example.hangman.model.entity.response;

public class GetCurrentResultResponseEntity {
	
	String sessionId;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	class data{
		int totalWordCount;
		int correctWordCount;
		int totalWrongGuessCount;
		int score;
		public int getTotalWordCount() {
			return totalWordCount;
		}
		public void setTotalWordCount(int totalWordCount) {
			this.totalWordCount = totalWordCount;
		}
		public int getCorrectWordCount() {
			return correctWordCount;
		}
		public void setCorrectWordCount(int correctWordCount) {
			this.correctWordCount = correctWordCount;
		}
		public int getTotalWrongGuessCount() {
			return totalWrongGuessCount;
		}
		public void setTotalWrongGuessCount(int totalWrongGuessCount) {
			this.totalWrongGuessCount = totalWrongGuessCount;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		
	}
}
