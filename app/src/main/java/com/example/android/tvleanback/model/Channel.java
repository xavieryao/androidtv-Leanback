package com.example.android.tvleanback.model;

/**
 * Created by Xavier Yao on 2018/2/10.
 */

public class Channel {
	public final String name; // "Name"
	public final String mediaName; // "Vid"

	private String mMediaUrl;

	public Channel(String name, String mediaName) {
		this.name = name;
		this.mediaName = mediaName;
	}

	public String getMediaUrl() {
		if (mMediaUrl == null) {
			mMediaUrl = String.format("https://iptv.tsinghua.edu.cn/hls/%s", this.mediaName);
		}
		return mMediaUrl;
	}
}
