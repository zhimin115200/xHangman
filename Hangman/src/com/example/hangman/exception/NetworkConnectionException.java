package com.example.hangman.exception;

import com.example.hangman.present.ErrorBundle;

/**
 * Exception throw by the application when a there is a network connection exception.
 */
public class NetworkConnectionException extends Exception implements ErrorBundle{

	public NetworkConnectionException() {
		super();
	}

	public NetworkConnectionException(final String message) {
		super(message);
	}

	public NetworkConnectionException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public NetworkConnectionException(final Throwable cause) {
		super(cause);
	}

	@Override
	public Exception getException() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return this.getMessage();
	}
}
