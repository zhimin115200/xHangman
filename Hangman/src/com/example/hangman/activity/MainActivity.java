package com.example.hangman.activity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.hangman.R;
import com.example.hangman.R.layout;
import com.example.hangman.R.menu;
import com.example.hangman.common.CommonConstans;
import com.example.hangman.executor.JobExecutor;
import com.example.hangman.executor.PostExecutionThread;
import com.example.hangman.executor.ThreadExecutor;
import com.example.hangman.executor.UIThread;
import com.example.hangman.interactor.GetWordUseCaseImpl;
import com.example.hangman.interactor.IGetWordUseCase;
import com.example.hangman.model.DataSource;
import com.example.hangman.model.DataSource.GetWordCallback;
import com.example.hangman.model.DataSourceFactory;
import com.example.hangman.model.DataSourceFactory.DataSourceType;
import com.example.hangman.present.ErrorBundle;
import com.example.hangman.present.GetWordPresenter;
import com.example.hangman.present.GuessLetterPresenter;
import com.example.hangman.present.view.ILoadLetterView;
import com.example.hangman.present.view.ILoadWordView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements ILoadWordView , ILoadLetterView , OnClickListener{

	GetWordPresenter getWordPresenter;
	GuessLetterPresenter guessLetterPresenter;
	String word="";
	TextView hiddenwordTv;
	ArrayList<Button>  lettersBtn = new ArrayList<Button>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		initializeView();
		initializePresenter();
		
		this.getWordPresenter.getWord();
	}
	
	void initializeView(){
		setContentView(R.layout.main);
		lettersBtn.add((Button)this.findViewById(R.id.a_btn));
		lettersBtn.add((Button)this.findViewById(R.id.b_btn));
		lettersBtn.add((Button)this.findViewById(R.id.c_btn));
		lettersBtn.add((Button)this.findViewById(R.id.d_btn));
		lettersBtn.add((Button)this.findViewById(R.id.e_btn));
		lettersBtn.add((Button)this.findViewById(R.id.f_btn));
		lettersBtn.add((Button)this.findViewById(R.id.g_btn));
		lettersBtn.add((Button)this.findViewById(R.id.h_btn));
		lettersBtn.add((Button)this.findViewById(R.id.i_btn));
		
		lettersBtn.add((Button)this.findViewById(R.id.j_btn));
		lettersBtn.add((Button)this.findViewById(R.id.k_btn));
		lettersBtn.add((Button)this.findViewById(R.id.l_btn));
		lettersBtn.add((Button)this.findViewById(R.id.m_btn));
		lettersBtn.add((Button)this.findViewById(R.id.n_btn));
		lettersBtn.add((Button)this.findViewById(R.id.o_btn));
		lettersBtn.add((Button)this.findViewById(R.id.p_btn));
		lettersBtn.add((Button)this.findViewById(R.id.q_btn));
		lettersBtn.add((Button)this.findViewById(R.id.r_btn));
		lettersBtn.add((Button)this.findViewById(R.id.s_btn));
		lettersBtn.add((Button)this.findViewById(R.id.t_btn));
		lettersBtn.add((Button)this.findViewById(R.id.u_btn));
		lettersBtn.add((Button)this.findViewById(R.id.v_btn));
		lettersBtn.add((Button)this.findViewById(R.id.w_btn));
		lettersBtn.add((Button)this.findViewById(R.id.x_btn));
		lettersBtn.add((Button)this.findViewById(R.id.y_btn));
		lettersBtn.add((Button)this.findViewById(R.id.z_btn));
		for(int i = 0 ; i < lettersBtn.size(); i++){
			lettersBtn.get(i).setOnClickListener(this);
			lettersBtn.get(i).setTag(i);
		}
		hiddenwordTv = (TextView)this.findViewById(R.id.hiddenword);
		
		
	}
	
	void initializePresenter() {

		ThreadExecutor threadExecutor = JobExecutor.getInstance();
		PostExecutionThread postExecutionThread = UIThread.getInstance();

		DataSource dataSource =
				new DataSourceFactory(this.getApplicationContext()).create(DataSourceFactory.DataSourceType.LOCAL);

		IGetWordUseCase getWordUseCase = new GetWordUseCaseImpl(this.getApplicationContext(),dataSource,
				threadExecutor, postExecutionThread);

		this.getWordPresenter =
				new GetWordPresenter(this.getApplicationContext(),this, getWordUseCase);
		
		this.guessLetterPresenter = new GuessLetterPresenter(this);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void renserWord(String word) {
		// TODO Auto-generated method stub
		
		this.word=word;
		String wordTmp=word.replaceAll("[a-zA-Z]",CommonConstans.defaultHint);
		showWord(wordTmp);
	}
	@Override
	public void letterFailed(char c, String result) {
		// TODO Auto-generated method stub
		showWord(result);
		hindKey(c);
	}
	@Override
	public void letterSuccessed(char c, String result) {
		// TODO Auto-generated method stub
		showWord(result);
		hindKey(c);
	}
	@Override
	public void wordSuccess() {
		// TODO Auto-generated method stub
		this.getWordPresenter.getWord();
		initializeView();
		initializePresenter();
		
	} 
	
	private void showWord(String word){
		hiddenwordTv.setText(word);
	}

	private void hindKey(char c){
		Button btn = lettersBtn.get(c-97);
		btn.setVisibility(View.GONE);
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Button btn = (Button)arg0;
		int tag = Integer.valueOf(btn.getTag().toString());
		char c = (char)(tag +97);
		
		this.guessLetterPresenter.tryGuess(this.word, c);
	}
}
