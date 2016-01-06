package com.example.hangman.model.entity.request;


public class GuessRequestEntity extends RequestEntity{

	String guess;

	public String getGuess() {
		return guess;
	}

	public void setGuess(String guess) {
		this.guess = guess;
	}
	
}
