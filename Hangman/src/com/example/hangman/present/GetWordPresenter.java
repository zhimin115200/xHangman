
package com.example.hangman.present;

import android.content.Context;
import android.util.Log;

import com.example.hangman.interactor.IGetWordUseCase;
import com.example.hangman.model.DataSource;
import com.example.hangman.model.DataSourceFactory;
import com.example.hangman.model.DataSourceFactory.DataSourceType;
import com.example.hangman.present.view.ILoadWordView;

public class GetWordPresenter {

	private Context mContext;
	private final ILoadWordView loadWordView;
	private final IGetWordUseCase getWordUseCase;

	public GetWordPresenter(Context context , ILoadWordView loadWordView,
			IGetWordUseCase getWordUseCase) {
		if (context==null||loadWordView == null || getWordUseCase == null ) {
			throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
		}
		this.mContext=context;
		this.loadWordView = loadWordView;
		this.getWordUseCase = getWordUseCase;
	}

	private void sendWord(String word) {
		this.loadWordView.renserWord(word);
	}

	public void getWord() {
		this.getWordUseCase.execute( this.userDetailsCallback);
	}

	public void changeDataSource(DataSourceType type){
		getWordUseCase.changeDataSource(new DataSourceFactory(mContext).create(type));
	}
	private final DataSource.GetWordCallback userDetailsCallback = new DataSource.GetWordCallback () {

		@Override
		public void onResult(String word) {
			// TODO Auto-generated method stub
			sendWord(word);
		}

		@Override
		public void onError(ErrorBundle errorBundle) {
			// TODO Auto-generated method stub
			//失败后从本地取
			Log.e(GetWordPresenter.class.getSimpleName(), errorBundle.getException().getMessage());
			getWordUseCase.changeDataSource(new DataSourceFactory(mContext).create(DataSourceType.LOCAL));
			getWord();
		}
	};
}
