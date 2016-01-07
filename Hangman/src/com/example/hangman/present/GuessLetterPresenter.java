package com.example.hangman.present;

import java.util.ArrayList;

import com.example.hangman.common.CommonConstans;
import com.example.hangman.present.view.ILoadLetterView;

public class GuessLetterPresenter {

	ILoadLetterView loadLetterView;
	public GuessLetterPresenter(ILoadLetterView loadLetterView){
		
		this.loadLetterView = loadLetterView;
	}
	public void tryGuess(String realWord , String currentWord , char c){
		
		StringBuffer wordTmp = new StringBuffer(currentWord);
		boolean isLetterSuccess=false;
		ArrayList<Integer> indexs = new ArrayList<Integer>();
		for(int i=0;i<realWord.length();i++){
			
			char charTmp=realWord.charAt(i);
			if(charTmp==c){
				
				wordTmp.replace(i, i+1, String.valueOf(charTmp));
				isLetterSuccess=true;
				indexs.add(i);
			}
		}
		if(wordTmp.toString().equals(realWord)){
			
			this.loadLetterView.wordSuccess();
		}else if(isLetterSuccess){
			
			this.loadLetterView.letterSuccessed(c, indexs);
		}else {
			
			this.loadLetterView.letterFailed(c);
		}
		
	}
}
