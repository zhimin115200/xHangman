/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.example.hangman.model;

import android.content.Context;

import com.example.hangman.present.ErrorBundle;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface DataSource {
	/**
	 * Callback used for clients to be notified when either a user list has been loaded or any error
	 * occurred.
	 */
	interface GetWordCallback {
		
		void onResult(String word);

		void onError(ErrorBundle errorBundle);
	}


	/**
	 * Get a collection of {@link com.fernandocejas.android10.sample.domain.User}.
	 *
	 * @param userListCallback A {@link UserListCallback} used for notifying clients.
	 */
	void getWord(Context context , GetWordCallback callback);

}
