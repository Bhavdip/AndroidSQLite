package com.adb.test.sql.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.adb.test.sql.FoodBazerApplication;

public abstract class BaseDAO {
	
	protected FoodBazerApplication mFoodBazerApp;
	protected SQLiteDatabase mSQLitBaseDAO; 
	
	public BaseDAO()
	{
		mFoodBazerApp = FoodBazerApplication.getInstance();
		mSQLitBaseDAO = mFoodBazerApp.mAppLevelDB;
	}
	
	public BaseDAO(SQLiteDatabase aDB)
	{
		mSQLitBaseDAO = aDB;
	}
	
	public boolean hasDBConnected()
	{
		return mSQLitBaseDAO!= null;
	}
	
	public int getInt(Cursor aCursor,String columnName)
	{	//1. Returns the index for the given column name
		//2. then same cursor use to get value 
		return aCursor.getInt(aCursor.getColumnIndexOrThrow(columnName));
	}
	
	public String getString(Cursor aCursor,String columnName)
	{	
		//1. Returns the index for the given column name
		//2. then same cursor use to get value 
		return aCursor.getString(aCursor.getColumnIndexOrThrow(columnName));
	}
	
	public long getLong(Cursor aCursor,String columnName)
	{
		return aCursor.getLong(aCursor.getColumnIndexOrThrow(columnName));
	}
	
}
