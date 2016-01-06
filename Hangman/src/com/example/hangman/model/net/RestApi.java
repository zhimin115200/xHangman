/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.example.hangman.model.net;

import com.example.hangman.present.ErrorBundle;

/**
 * RestApi for retrieving data from the network.
 */
public interface RestApi {
	
	/**
	 * Callback used to be notified when either a user list has been loaded or an error happened.
	 */
	interface GetWordCallback {

		void onResult(String word);

		void onError(ErrorBundle bundle);
	}


	static final String API_BASE_URL = "http://charliex.altervista.org/generatorword/parola/en";

	/**
	 * Get a collection of {@link User}.
	 *
	 * @param userListCallback A {@link UserListCallback} used for notifying clients.
	 */
	void getWord( GetWordCallback callback);
	
}
