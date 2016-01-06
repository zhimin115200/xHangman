
package com.example.hangman.model.net;

import com.example.hangman.present.ErrorBundle;

/**
 * 网络操作的rest接口
 */
public interface RestApi {
	
	interface GetWordCallback {

		void onResult(String word);

		void onError(ErrorBundle bundle);
	}


	static final String API_BASE_URL = "http://charliex.altervista.org/generatorword/parola/en";

	void getWord( GetWordCallback callback);
}
