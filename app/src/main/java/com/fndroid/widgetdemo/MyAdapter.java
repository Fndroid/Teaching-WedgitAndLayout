package com.fndroid.widgetdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/5/22.
 */
public class MyAdapter extends BaseAdapter {
	private Context mContext;
	private List<Goods> mGoodsList;

	public MyAdapter(Context context, List<Goods> data) {
		mContext = context;
		mGoodsList = data;
	}

	public class ViewHolder{
		ImageView mImageView;
		TextView mTextView;
		ProgressBar mProgressBar;
	}

	@Override
	public int getCount() {
		return mGoodsList.size();
	}

	@Override
	public Object getItem(int position) {
		return mGoodsList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		ViewHolder viewHolder;
		if (convertView != null){
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}else{
			view = LayoutInflater.from(mContext).inflate(R.layout.list_item, null);
			viewHolder = new ViewHolder();
			viewHolder.mImageView = (ImageView) view.findViewById(R.id.iv_pic);
			viewHolder.mTextView = (TextView) view.findViewById(R.id.tv_title);
			viewHolder.mProgressBar = (ProgressBar) view.findViewById(R.id.pb_hot);
			view.setTag(viewHolder);
		}
		Goods g = mGoodsList.get(position);
		viewHolder.mTextView.setText(g.title);
		viewHolder.mImageView.setImageResource(g.image);
		viewHolder.mProgressBar.setProgress(g.hot);
		return view;
	}
}
