package com.example.btphone.adpter;

import java.util.ArrayList;
import java.util.List;

import com.example.btphone.R;
import com.example.btphone.bean.CallInfo;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CalllogDetailListAdapter extends BaseAdapter{
	
	private List<CallInfo>list =new ArrayList<CallInfo>();
	private Context mContext;
	private Handler mHandler;
    private String TAG="CalllogDetailListAdapter";
	public CalllogDetailListAdapter(Context context){   //构造方法
		mContext=context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	public void setData(ArrayList<CallInfo> list){
		this.list=list;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		View view = convertView;
		if (view == null) {
			holder = new ViewHolder();
			LayoutInflater inflater = LayoutInflater.from(mContext);
			view = inflater.inflate(R.layout.calllog_detail_each_item, null);
			holder.ivCallType = (ImageView) view
					.findViewById(R.id.type);
			holder.tvTime = (TextView) view.findViewById(R.id.time);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		CallInfo info = list.get(position);
		holder.tvTime.setText(info.getDate());
        Log.d(TAG,"info.getDate()="+info.getDate());
		if (info.getCallType() == 6) {
			holder.ivCallType.setImageResource(R.drawable.icar_ic_ct_incoming);
		} else if (info.getCallType() == 7) {
			holder.ivCallType.setImageResource(R.drawable.icar_ic_ct_outgoing);
		} else if (info.getCallType() == 5) {
			holder.ivCallType.setImageResource(R.drawable.icar_ic_ct_miss);
		}

		return view;
	}
	
	class ViewHolder {
		ImageView ivCallType;
		TextView tvTime;
	}

}
