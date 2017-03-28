package com.example.btphone.adpter;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.example.btphone.R;
import com.example.btphone.bean.CallInfo;

import android.content.Context;
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
		holder.tvTime.setText(TimestamptoDate(info.getDate()));
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
	
	public String TimestamptoDate(String time) { 
		
		String re_StrTime = "未知";
		String call_date = "未知";
	    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
	    SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd HH:mm");
	   Date date = null;
		try {
			date =  sdf1.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//提取格式中的日期
	    re_StrTime= sdf2.format(date);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Date curDate = new Date(System.currentTimeMillis());
		String today = formatter.format(curDate);
		call_date= formatter.format(date);

		if (today.equals(call_date)) {
			SimpleDateFormat sfd1 = new SimpleDateFormat("今天  hh:mm");
			re_StrTime = sfd1.format(date);
		}
		return re_StrTime;

	}

}
