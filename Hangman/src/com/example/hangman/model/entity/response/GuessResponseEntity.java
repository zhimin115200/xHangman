package com.example.hangman.model.entity.response;

public class GuessResponseEntity {

	String sessionId;
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	class data{
		String word;
		int totalWordCount;
		int wrongGuessCountOfCurrentWord;
		public String getWord() {
			return word;
		}
		public void setWord(String word) {
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
