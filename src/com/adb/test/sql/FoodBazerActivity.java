package com.adb.test.sql;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.widget.ListView;

import com.adb.test.sql.adapter.MarchantAdapter;
import com.adb.test.sql.util.MarchantLoader;

public class FoodBazerActivity extends FragmentActivity implements LoaderCallbacks<Cursor> {
	
	private ListView listview_marchantList;
	private MarchantAdapter mMarchantAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foodbazer);
		listview_marchantList = (ListView)findViewById(R.id.listview_marchantList);
		mMarchantAdapter = new MarchantAdapter(getApplicationContext());
		listview_marchantList.setAdapter(mMarchantAdapter);
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
}
