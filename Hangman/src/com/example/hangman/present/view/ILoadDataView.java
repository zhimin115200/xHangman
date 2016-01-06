package com.example.hangman.present.view;

public interface ILoadDataView {

	void renderWord(String word);
	
	void unClickLetter(char c);
	
	void renderScore(String score);
}
