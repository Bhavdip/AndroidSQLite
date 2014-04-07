package com.adb.test.sql.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.TextView;

import com.adb.test.sql.R;
import com.adb.test.sql.model.FoodMarchantModel;

public class MarchantAdapter extends CursorAdapter implements Filterable{

	private LayoutInflater mLayoutInflater;
	
	public MarchantAdapter(Context context) {
		super(context,null,0);
		mLayoutInflater = LayoutInflater.from(context);
	}

	@Override
	public void bindView(View convertview, Context arg1, Cursor aCursor) {
		final FoodMarchantModel tmp = constructModel(aCursor);
		ViewHolder mViewItem = (ViewHolder)convertview.getTag();
		mViewItem.textview_marchant.setText(tmp.getMarchant());
		mViewItem.textview_owner.setText(tmp.getOwner());
		mViewItem.textview_address.setText(tmp.getAddress());
		mViewItem.textview_phone.setText(tmp.getPhone());
	}

	@Override
	public View newView(Context arg0, Cursor arg1, ViewGroup aViewGroup) {
		final View convertView = mLayoutInflater.inflate(R.layout.row_murchant_items,aViewGroup,false);
		ViewHolder mViewHolder = new ViewHolder();
		mViewHolder.textview_marchant = (TextView)convertView.findViewById(R.id.textview_marchant);
		mViewHolder.textview_owner = (TextView)convertView.findViewById(R.id.textview_ownerinfo);
		mViewHolder.textview_address = (TextView)convertView.findViewById(R.id.textview_address);
		mViewHolder.textview_phone = (TextView)convertView.findViewById(R.id.textview_phone);
		convertView.setTag(mViewHolder);
		return convertView;
	}

	@Override
	public int getCount() {
		 return getCursor() == null ? 0 : super.getCount();
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
	
	class ViewHolder
	{
		TextView textview_marchant;
		TextView textview_owner;
		TextView textview_phone;
		TextView textview_address;
	}
	
	@Override
	public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
		return super.runQueryOnBackgroundThread(constraint);
	}
}
