package com.example.android.tvleanback.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xavier Yao on 2018/2/12.
 */

public class Category {
	public final String name;
	public final List<Category> channels = new ArrayList<>();

	public Category(String name) {
		this.name = name;
	}

	private Category() {
		// Hidden constructor
		this.name = null;
	}
}
