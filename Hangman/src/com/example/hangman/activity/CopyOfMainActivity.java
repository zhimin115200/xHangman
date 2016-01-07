package com.example.hangman.activity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.hangman.R;
import com.example.hangman.R.layout;
import com.example.hangman.R.menu;
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

public class CopyOfMainActivity extends Activity implements ILoadWordView{

	GetWordPresenter getWordPresenter;
	boolean flag = false;
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView)this.findViewById(R.id.textView1);
		Button btn = (Button)this.findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				getWordPresenter.getWord();
			}
		});
		Button btn2 = (Button)this.findViewById(R.id.button2);
		btn2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(flag){
					getWordPresenter.changeDataSource(DataSourceType.CLOUD);
					flag=false;
					Toast.makeText(getApplicationContext(), "云", Toast.LENGTH_SHORT).show();
				}else{
					getWordPresenter.changeDataSource(DataSourceType.LOCAL);
					Toast.makeText(getApplicationContext(), "本地", Toast.LENGTH_SHORT).show();
					flag=true;
				}

			}
		});
		initializePresenter();
	}
	void initializePresenter() {
		// All these dependency initialization could have been avoided using a
		// dependency injection framework. But in this case are used this way for
		// LEARNING EXAMPLE PURPOSE.
		ThreadExecutor threadExecutor = JobExecutor.getInstance();
		PostExecutionThread postExecutionThread = UIThread.getInstance();

		DataSource dataSource =
				new DataSourceFactory(this.getApplicationContext()).create(DataSourceFactory.DataSourceType.LOCAL);

		IGetWordUseCase getWordUseCase = new GetWordUseCaseImpl(this.getApplicationContext(),dataSource,
				threadExecutor, postExecutionThread);

		this.getWordPresenter =
				new GetWordPresenter(this.getApplicationContext(),this, getWordUseCase);
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
		
		tv.setText(word);
	} 
}
