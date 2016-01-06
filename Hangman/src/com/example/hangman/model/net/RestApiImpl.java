
package com.example.hangman.model.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Collection;

import com.example.hangman.exception.NetworkConnectionException;
import com.example.hangman.model.entity.Mapper;

public class RestApiImpl implements RestApi {

	private final Context context;
	private final Mapper entityJsonMapper;

	public RestApiImpl(Context context, Mapper entityJsonMapper) {
		if (context == null || entityJsonMapper == null) {
			throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
		}
		this.context = context.getApplicationContext();
		this.entityJsonMapper = entityJsonMapper;
	}

	private boolean isThereInternetConnection() {
		boolean isConnected;

		ConnectivityManager connectivityManager =
				(ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

		return isConnected;
	}

	@Override
	public void getWord(GetWordCallback callback) {
		// TODO Auto-generated method stub
		if (callback == null) {
			throw new IllegalArgumentException("Callback cannot be null!!!");
		}

		if (isThereInternetConnection()) {
			try {
				ApiConnection startGameConnection =
						ApiConnection.createGET(RestApi.API_BASE_URL);
				String response = startGameConnection.requestSyncCall();
				String word =
						this.entityJsonMapper.transformGetWordResponse(response);

				callback.onResult(word);
			} catch (Exception e) {
				callback.onError(new NetworkConnectionException(e.getCause()));
			}
		} else {
			callback.onError(new NetworkConnectionException());
		}
	}
}
