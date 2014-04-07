package com.adb.test.sql;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;

import com.adb.test.sql.DAO.FoodMarchantDAO;
import com.adb.test.sql.adapter.MarchantAdapter;
import com.adb.test.sql.util.MarchantLoader;

public class FoodBazerActivity extends FragmentActivity implements LoaderCallbacks<Cursor>{
	
	private ListView listview_marchantList;
	private MarchantAdapter mMarchantAdapter;
	private EditText search_view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foodbazer);
		listview_marchantList = (ListView)findViewById(R.id.listview_marchantList);
		mMarchantAdapter = new MarchantAdapter(getApplicationContext());
		listview_marchantList.setAdapter(mMarchantAdapter);
		mMarchantAdapter.setFilterQueryProvider(new FilterQueryProvider() {
			
			@Override
			public Cursor runQuery(CharSequence constraint) {
				return new FoodMarchantDAO().getSearchMarchantQuery(constraint);
			}
		});
		
		search_view = (EditText)findViewById(R.id.search_view);
		search_view.addTextChangedListener(queryWatcher);
		
		getSupportLoaderManager().initLoader(1,null,this);
	}
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
		return new MarchantLoader(this);
	}

	@Override
	public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor newCursor) {
		mMarchantAdapter.swapCursor(newCursor);
	}

	@Override
	public void onLoaderReset(Loader<Cursor> cursorLoader) {
		mMarchantAdapter.swapCursor(null);
	}
	
	TextWatcher queryWatcher = new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}
		
		@Override
		public void afterTextChanged(Editable s) {
			mMarchantAdapter.getFilter().filter(s.toString());
		}
	};
}
