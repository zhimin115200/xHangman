/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.example.hangman.model.net;

import android.content.Context;

import com.example.hangman.model.DataSource;
import com.example.hangman.present.ErrorBundle;

/**
 * {@link DataSource} implementation based on connections to the api (Cloud).
 */
public class CloudDataStore implements DataSource {

	private final RestApi restApi;


	/**
	 * Construct a {@link DataSource} based on connections to the api (Cloud).
	 *
	 * @param restApi The {@link RestApi} implementation to use.
	 * @param userCache A {@link UserCache} to cache data retrieved from the api.
	 */
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
