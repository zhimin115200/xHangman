package com.example.hangman.model.entity.response;

public class SubmitResponseEntity {
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	String message;
	String sessionId;
	class data{
		
		public String getPlayerId() {
			return playerId;
		}
		public void setPlayerId(String playerId) {
			this.playerId = playerId;
		}
		public String getSessionId() {
			return sessionId;
		}
		public void setSessionId(String sessionId) {
			this.sessionId = sessionId;
		}
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
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		public String getDatetime() {
			return datetime;
		}
		public void setDatetime(String datetime) {
			this.datetime = datetime;
		}
		String playerId;
		String sessionId;
		int totalWordCount;
		int correctWordCount;
		int score;
		String datetime;
	}
}
