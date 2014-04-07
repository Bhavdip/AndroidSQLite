package com.adb.test.sql;

import com.adb.test.sql.data.SQLite;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

public class FoodBazerApplication extends Application{
	
	private static FoodBazerApplication mFoodBazerApplication;
	
	public SQLiteDatabase mAppLevelDB;
	
	public static FoodBazerApplication getInstance()
	{
		return mFoodBazerApplication;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		mFoodBazerApplication = this;
		SQLite tmpSQL= new SQLite(this, SQLite.DATABASE_NAME, null, SQLite.DATABASE_VERSION);
		// it return null if first time database create onCreate() called,
		// once database create it will open the database so openDataBase() called
		mAppLevelDB = tmpSQL.getWritableDatabase();
	}
}
