package com.example.hangman.present;

import com.example.hangman.common.CommonConstans;
import com.example.hangman.present.view.ISubmitView;

public class SubmitPresenter {

	int score = 0;
	int count = 0;
	int tryCount = 0;
	ISubmitView submitView;
	
	public SubmitPresenter(ISubmitView submitView){
		this.submitView = submitView ;
	}
	
	public void tryCountPlus(){
		tryCount = tryCount + 1;
	}
	public void caculate(){
		
		if(tryCount!=0){
			
			score = score + ( CommonConstans.defaultTryCount + 1 - tryCount );
			count = count + 1;
			tryCount = 0;
		}
		renderScore();
		renderCount();
	}
	
	private void renderScore(){
		submitView.renderScore(score);
	}
	private void renderCount(){
		submitView.renderCount(count);
	}
}
