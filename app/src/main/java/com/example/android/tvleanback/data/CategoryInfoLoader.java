package com.example.android.tvleanback.data;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.example.android.tvleanback.model.CategoryInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Xavier Yao on 2018/2/12.
 */

public class CategoryInfoLoader extends AsyncTaskLoader<CategoryInfo> {

	private static final String CATEGORY_DIRECTORY_URL = "https://iptv.tsinghua.edu.cn/channels_tsinghua.json";

	public CategoryInfoLoader(Context context) {
		super(context);
	}

	@Override
	public CategoryInfo loadInBackground() {
		OkHttpClient client = new OkHttpClient();
		CategoryInfo info = null;
		try {
			Request request = new Request.Builder()
					.url(CATEGORY_DIRECTORY_URL)
					.build();
			Response response = client.newCall(request).execute();
			String respStr = response.body().string();
			info = CategoryInfo.fromJSON(respStr);
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}

		return info;
	}
}
