/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.example.hangman.interactor;

import android.content.Context;

import com.example.hangman.executor.PostExecutionThread;
import com.example.hangman.executor.ThreadExecutor;
import com.example.hangman.model.DataSource;
import com.example.hangman.model.entity.response.StartResponseEntity;
import com.example.hangman.present.ErrorBundle;

/**
 * This class is an implementation of {@link IStartGameUseCase} that represents a use case for
 * retrieving a collection of all {@link User}.
 */
public class GetWordUseCaseImpl implements IGetWordUseCase {

	private Context mContext;
	private DataSource dataSource;
	private final ThreadExecutor threadExecutor;
	private final PostExecutionThread postExecutionThread;
	private DataSource.GetWordCallback callback;

	/**
	 * Constructor of the class.
	 *
	 * @param userRepository A {@link UserRepository} as a source for retrieving data.
	 * @param threadExecutor {@link ThreadExecutor} used to execute this use case in a background
	 * thread.
	 * @param postExecutionThread {@link PostExecutionThread} used to post updates when the use case
	 * has been executed.
	 */
	public GetWordUseCaseImpl(Context context , DataSource dataSource, ThreadExecutor threadExecutor,
			PostExecutionThread postExecutionThread) {
		if (context==null||dataSource == null || threadExecutor == null || postExecutionThread == null) {
			throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
		}
		this.mContext=context;
		this.dataSource = dataSource;
		this.threadExecutor = threadExecutor;
		this.postExecutionThread = postExecutionThread;
	}
	
	@Override 
	public void execute(DataSource.GetWordCallback callback) {
		if (callback == null) {
			throw new IllegalArgumentException("Interactor callback cannot be null!!!");
		}
		this.callback = callback;
		this.threadExecutor.execute(this);
	}

	@Override 
	public void run() {
		this.dataSource.getWord(mContext , repositoryCallback);
	}

	private final DataSource.GetWordCallback repositoryCallback =
			new DataSource.GetWordCallback() {
		@Override 
		public void onResult(String word){
			notifySuccessfully(word);
		}

		@Override 
		public void onError(ErrorBundle errorBundle) {
			notifyError(errorBundle);
		}
	};

	private void notifySuccessfully(final String word) {
		this.postExecutionThread.post(new Runnable() {
			@Override public void run() {
				callback.onResult(word);
			}
		});
	}

	private void notifyError(final ErrorBundle errorBundle) {
		this.postExecutionThread.post(new Runnable() {
			@Override public void run() {
				callback.onError(errorBundle);
			}
		});
	}

	@Override
	public void changeDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.dataSource = dataSource;
	}

}
