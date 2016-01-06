
package com.example.hangman.model.net;

import android.content.Context;

import com.example.hangman.model.DataSource;
import com.example.hangman.present.ErrorBundle;


public class CloudDataStore implements DataSource {

	private final RestApi restApi;

	public CloudDataStore(RestApi restApi) {
		this.restApi = restApi;
	}


	@Override
	public void getWord(Context context , final DataSource.GetWordCallback callback) {
		// TODO Auto-generated method stub
		restApi.getWord(new RestApi.GetWordCallback(){

			@Override
			public void onResult(String word) {
				// TODO Auto-generated method stub
				callback.onResult(word);
			}

			@Override
			public void onError(ErrorBundle errorBundle) {
				// TODO Auto-generated method stub
				callback.onError(errorBundle);
			}
			
		});
	}
}
