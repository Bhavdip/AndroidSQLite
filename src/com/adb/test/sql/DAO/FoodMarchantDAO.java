package com.adb.test.sql.DAO;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.adb.test.sql.model.FoodMarchantModel;

public class FoodMarchantDAO extends BaseDAO{
	
	
	public FoodMarchantDAO()
	{
		super();
	}
	
	public FoodMarchantDAO(SQLiteDatabase aDB)
	{
		super(aDB);
	}
	
	public void executeTableMarchant()
	{
		mSQLitBaseDAO.execSQL("create table foodMarchant ( _id INTEGER PRIMARY KEY AUTOINCREMENT, marchant TEXT, owner TEXT,address TEXT,phone TEXT)");
	}
	
	public void saveNewMarchant(FoodMarchantModel aMarchantModel)
	{
		if(hasDBConnected())
		{
			Object[] values = new Object[] { aMarchantModel.getMarchant(),aMarchantModel.getOwner(), aMarchantModel.getAddress(), aMarchantModel.getPhone()};
			mSQLitBaseDAO.execSQL("insert into foodMarchant ( marchant, owner, address,phone)  values ( ?, ?, ?, ?)" , values);	
		}
	}
	
	public List<FoodMarchantModel> getAllMarchants()
	{
		List<FoodMarchantModel> allMarchants = new ArrayList<FoodMarchantModel>();
		
		Cursor aCursor = mSQLitBaseDAO.rawQuery("select _id, marchant, owner, address, phone from foodMarchant",null);
		if(aCursor != null)
		{
			aCursor.moveToFirst();
			while(!aCursor.isAfterLast())
			{
				FoodMarchantModel tmpleteModel = constructModel(aCursor);
				allMarchants.add(tmpleteModel);
				aCursor.moveToNext();
			}
		}
		aCursor.close();
		return allMarchants;
		
	}
	
	public Cursor getAllMarchantsCursor()
	{
		return mSQLitBaseDAO.rawQuery("select _id, marchant, owner, address, phone from foodMarchant",null);
	}
	
	public FoodMarchantModel constructModel(Cursor aCursor)
	{
		FoodMarchantModel retValue = new FoodMarchantModel()
		.setId(getInt(aCursor,"_id"))
		.setMarchant(getString(aCursor,"marchant"))
		.setOwner(getString(aCursor,"owner"))
		.setAddress(getString(aCursor,"address"))
		.setPhone(getString(aCursor, "phone"));
		return retValue;
	}
	
	public void loadDummyMarchant(){
		for(int i=0;i<100;i++){
			saveNewMarchant(new FoodMarchantModel()
					.setMarchant(String.format("ABC Food Center %3d",i))
					.setOwner(String.format("Mr.owner %2d",i))
					.setAddress(String.format("Ahmedabad-%2d",i))
					.setPhone(String.format("+91989843984%d",i)));
		}
	}
}

