package com.adb.test.sql.util;

import com.adb.test.sql.DAO.FoodMarchantDAO;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;

public class MarchantLoader extends CursorLoader {

	public MarchantLoader(Context context) {
		super(context);
	}

	@Override
	public Cursor loadInBackground() {
		Cursor aCur = new FoodMarchantDAO().getAllMarchantsCursor();
		return aCur;
	}

}
