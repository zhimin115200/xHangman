package com.example.hangman.model.entity.response;

public class StartResponseEntity {
	
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
		int numberOfWordsToGuess;
		int numberOfGuessAllowedForEachWord;
		public int getNumberOfWordsToGuess() {
			return numberOfWordsToGuess;
		}
		public void setNumberOfWordsToGuess(int numberOfWordsToGuess) {
			this.numberOfWordsToGuess = numberOfWordsToGuess;
		}
		public int getNumberOfGuessAllowedForEachWord() {
			return numberOfGuessAllowedForEachWord;
		}
		public void setNumberOfGuessAllowedForEachWord(
				int numberOfGuessAllowedForEachWord) {
			this.numberOfGuessAllowedForEachWord = numberOfGuessAllowedForEachWord;
		}
		
	}
}
