package com.adb.test.sql.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.adb.test.sql.DAO.FoodMarchantDAO;

public class SQLite extends SQLiteOpenHelper {
	
	public static int DATABASE_VERSION = 1;
	public static String DATABASE_NAME = "FoodBazer.db";
	
	/**
	 * Create a helper object to create, open, and/or manage a database. This method always returns very quickly. 
	 * The database is not actually created or opened until one of getWritableDatabase()
	 * or getReadableDatabase() is called.
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	public SQLite(Context context, String name, CursorFactory factory,int version) 
	{
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// when we call SQLiteDatabase getWritableDatabase() this would called
		// In fist time application install if no database then it would called once but that time Application 
		// database might be null we have to used here db
		new FoodMarchantDAO(db).executeTableMarchant();
		new FoodMarchantDAO(db).loadDummyMarchant();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
	
	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
	}
}
