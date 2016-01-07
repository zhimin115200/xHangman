package com.example.hangman.present.view;

import java.util.ArrayList;

public interface ILoadLetterView {


	void letterFailed(char c );
	void letterSuccessed(char c , ArrayList<Integer> indexs);
	void wordSuccess();
}
