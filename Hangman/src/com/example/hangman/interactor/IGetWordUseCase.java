
package com.example.hangman.interactor;

import com.example.hangman.model.DataSource;
import com.example.hangman.model.entity.response.StartResponseEntity;
import com.example.hangman.present.ErrorBundle;


public interface IGetWordUseCase extends Interactor {


  void execute(DataSource.GetWordCallback callback);
  
  void changeDataSource(DataSource dataSource);
}
