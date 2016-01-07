package com.example.hangman.present.view;

public interface ILoadLetterView {


	void letterFailed(char c , String result);
	void letterSuccessed(char c , String result);
	void wordSuccess();
}
