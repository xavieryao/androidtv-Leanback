package com.example.android.tvleanback.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xavier Yao on 2018/2/12.
 */

public class CategoryInfo extends ArrayList<Category> {
	public static CategoryInfo fromJSON(String jsonStr) throws JSONException {
		CategoryInfo info = new CategoryInfo();

		JSONObject dirObj = new JSONObject(jsonStr);
		JSONArray categoryArr = dirObj.getJSONArray("Categories");
		for (int i = 0; i < categoryArr.length(); i++) {
			JSONObject categoryObj = categoryArr.getJSONObject(i);
			Category category = Category.fromJSONObject(categoryObj);
			info.add(category);
		}
		return info;
	}
}
