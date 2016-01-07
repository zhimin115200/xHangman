package com.example.hangman.present;

import com.example.hangman.common.CommonConstans;
import com.example.hangman.present.view.ILoadLetterView;

public class GuessLetterPresenter {

	ILoadLetterView loadLetterView;
	public GuessLetterPresenter(ILoadLetterView loadLetterView){
		this.loadLetterView = loadLetterView;
	}
	public void tryGuess(String word , char c){
		StringBuffer wordTmp = new StringBuffer();

		boolean isLetterSuccess=false;
		for(int i=0;i<word.length();i++){
			char charTmp=word.charAt(i);
			if(charTmp==c){
				wordTmp.append(charTmp);
				isLetterSuccess=true;
			}
			else
				wordTmp.append(CommonConstans.defaultHint);
		}
		if(wordTmp.toString().equals(word)){
			this.loadLetterView.wordSuccess();
		}else if(isLetterSuccess){
			this.loadLetterView.letterSuccessed(c, wordTmp.toString());
		}else {
			this.loadLetterView.letterFailed(c, wordTmp.toString());
		}
		
	}
}
