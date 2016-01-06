/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.example.hangman.interactor;

import com.example.hangman.model.DataSource;
import com.example.hangman.model.entity.response.StartResponseEntity;
import com.example.hangman.present.ErrorBundle;

/**
 * This interface represents a execution unit for a use case to get a collection of {@link User}.
 * By convention this use case (Interactor) implementation will return the result using a Callback.
 * That callback should be executed in the UI thread.
 */
public interface IGetWordUseCase extends Interactor {


  /**
   * Executes this user case.
   *
   * @param callback A {@link IStartGameUseCase.Callback} used to notify the client.
   */
  void execute(DataSource.GetWordCallback callback);
  
  void changeDataSource(DataSource dataSource);
}
