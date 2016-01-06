package com.example.hangman.model.entity;

import org.json.JSONArray;
import org.json.JSONException;

public class Mapper {

	public Mapper() {
	}

	/**
	 * Transform from valid json string to {@link UserEntity}.
	 *
	 * @param userJsonResponse A json representing a user profile.
	 * @return {@link UserEntity}.
	 * @throws JSONException 
	 * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
	 */
	public String transformGetWordResponse(String response) throws JSONException {


		JSONArray json = new JSONArray(response);
		String word =json.get(0).toString();
		return word;

	}
}
