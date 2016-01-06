package com.example.hangman.model.entity.response;

public class NextWordResponseEntity {
	
	String message;
	String sessionId;
	
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

	class data{
		int word;
		int totalWordCount;
		int wrongGuessCountOfCurrentWord;
		public int getWord() {
			return word;
		}
		public void setWord(int word) {
			this.word = word;
		}
		public int getTotalWordCount() {
			return totalWordCount;
		}
		public void setTotalWordCount(int totalWordCount) {
			this.totalWordCount = totalWordCount;
		}
		public int getWrongGuessCountOfCurrentWord() {
			return wrongGuessCountOfCurrentWord;
		}
		public void setWrongGuessCountOfCurrentWord(int wrongGuessCountOfCurrentWord) {
			this.wrongGuessCountOfCurrentWord = wrongGuessCountOfCurrentWord;
		}
		
	}
}
