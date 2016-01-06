
package com.example.hangman.model;

import android.content.Context;

import com.example.hangman.present.ErrorBundle;

public interface DataSource {
	
	interface GetWordCallback {
		
		void onResult(String word);

		void onError(ErrorBundle errorBundle);
	}

	void getWord(Context context , GetWordCallback callback);

}
