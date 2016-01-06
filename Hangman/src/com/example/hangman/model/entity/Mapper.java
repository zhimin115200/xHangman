package com.example.hangman.model.entity;

import org.json.JSONArray;
import org.json.JSONException;

public class Mapper {

	public Mapper() {
	}

	/**
	 * 将网络请求得到的json转成string
	 */
	public String transformGetWordResponse(String response) throws JSONException {


		JSONArray json = new JSONArray(response);
		String word =json.get(0).toString();
		return word;

	}
}
