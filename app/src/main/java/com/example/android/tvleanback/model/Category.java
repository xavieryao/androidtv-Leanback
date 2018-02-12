package com.example.android.tvleanback.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xavier Yao on 2018/2/12.
 */

public class Category {
	public final String name;
	public final boolean hidden;
	public final List<Channel> channels = new ArrayList<>();

	public Category(String name, boolean hidden) {
		this.name = name;
		this.hidden = false;
	}

	public Category(String name) {
		this.name = name;
		this.hidden = false;
	}

	private Category() {
		// Hidden constructor
		this.name = null;
		this.hidden = false;
	}

	public static Category fromJSONObject(JSONObject obj) throws JSONException {
		String name = obj.getString("Name");
		boolean hidden = obj.getBoolean("Hidden");
		Category category = new Category(name, hidden);
		JSONArray channelArr = obj.getJSONArray("Channels");
		for (int i = 0; i < channelArr.length(); i++) {
			category.channels.add(Channel.fromJSONObject(channelArr.getJSONObject(i)));
		}
		return category;
	}
}
