/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.example.hangman.model.local;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.example.hangman.model.DataSource;


/**
 * {@link DataSource} implementation based on file system data store.
 */
public class LocalDataStore implements DataSource {


	static String[] words=null;
	@Override
	public void getWord(Context context , GetWordCallback callback) {
		// TODO Auto-generated method stub
		if(words==null){
			String str = getFromAssets(context,"word/en.json");
			try {
				JSONArray jsons = new JSONArray(str);
				words = new String[jsons.length()];
				for(int i=0 ; i < jsons.length() ;i++)
				{
					JSONObject myjObject = jsons.getJSONObject(i);
					String word = myjObject.getString("word");
					words[i] = word;
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int random=new Random().nextInt(words.length);
		String word = words[random];
		callback.onResult(word);
	}
	public String getFromAssets(Context context , String fileName){ 
		String Result="";
		try { 
			InputStreamReader inputReader = new InputStreamReader( context.getResources().getAssets().open(fileName) ); 
			BufferedReader bufReader = new BufferedReader(inputReader);
			String line="";

			while((line = bufReader.readLine()) != null)
				Result += line;
			return Result;
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		return Result;
	} 
}
