package com.fndroid.widgetdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
	private static final String TAG = "MainActivity";
	private ListView mListView;
	private List<Goods> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mListView = (ListView) findViewById(R.id.lv);
		setData();
		MyAdapter adapter = new MyAdapter(this, data);
		mListView.setAdapter(adapter);
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Log.d(TAG, "onItemClick: "+position);
			}
		});
	}

	private void setData() {
		data = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			Goods g = new Goods();
			g.title = "Apple" + i;
			g.image = R.drawable.apple;
			g.hot = new Random().nextInt(100);
			data.add(g);
		}
	}

	public void toastWithImage(View view){
		Toast toast = new Toast(this);
		View v = LayoutInflater.from(this).inflate(R.layout.toastWithImg, null);
		toast.setView(v);
		toast.show();
	}

}
