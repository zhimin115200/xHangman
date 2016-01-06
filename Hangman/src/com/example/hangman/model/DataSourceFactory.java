package com.example.hangman.model;


import com.example.hangman.model.entity.Mapper;
import com.example.hangman.model.local.LocalDataStore;
import com.example.hangman.model.net.CloudDataStore;
import com.example.hangman.model.net.RestApi;
import com.example.hangman.model.net.RestApiImpl;

import android.content.Context;

/**
 * 创建不同 {@link DataSource}的工厂.
 */
public class DataSourceFactory {

	public enum DataSourceType{
		LOCAL,
		CLOUD
	}
	private final Context context;

	public DataSourceFactory(Context context) {
		if (context == null ) {
			throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
		}
		this.context = context.getApplicationContext();
	}

	/**
	 * Create {@link DataSource} from DataSourceType.
	 */
	public DataSource create(DataSourceType type) {
		DataSource userDataStore;

		if (type==DataSourceType.LOCAL) {
			userDataStore = new LocalDataStore();
		} else {
			userDataStore = createCloudDataStore();
		}

		return userDataStore;
	}

	/**
	 * Create {@link DataSource} to retrieve data from the Cloud.
	 */
	public DataSource createCloudDataStore() {
		Mapper entityMapper = new Mapper();
		RestApi restApi = new RestApiImpl(this.context, entityMapper);

		return new CloudDataStore(restApi);
	}
}
