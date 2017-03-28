package com.example.btphone.adpter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.btphone.CalllogActivity;
import com.example.btphone.R;
import com.example.btphone.bean.CallInfo;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class CallListAdapter extends BaseAdapter {
	private List<CallInfo> callInfoList = new ArrayList<CallInfo>();
	private Context mContext;
	private boolean bDeleteState = false;
	private Handler mhandler;

	public CallListAdapter(Context context, Handler mhandler) {
		// TODO Auto-generated constructor stub
		this.mContext = context;
		this.mhandler = mhandler;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return callInfoList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setData(List<CallInfo> infoList) {
		this.callInfoList = infoList;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		View view = convertView;
		if (view == null) {
			holder = new ViewHolder();
			LayoutInflater inflater = LayoutInflater.from(mContext);
			view = inflater.inflate(R.layout.call_list_item, null);
			// holder.cbCheck = (CheckBox) view.findViewById(R.id.check);
			holder.tvNumber = (TextView) view.findViewById(R.id.number);
			holder.tvName = (TextView) view.findViewById(R.id.name);
			holder.ivCall = (Button) view.findViewById(R.id.call_icon);
			holder.ivType = (ImageView) view.findViewById(R.id.type);
			holder.ivBt = (ImageView) view.findViewById(R.id.bt_call_flag);
			holder.tvData = (TextView) view.findViewById(R.id.data);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		final CallInfo info = callInfoList.get(position);
		holder.tvName.setText(info.getName());
		holder.tvNumber.setText(info.getPhoneNum());
		holder.tvData.setText(TimestamptoDate(info.getDate()));
		if (info.getCallType() == 6) { // 来电
			holder.ivType.setImageResource(R.drawable.icar_ic_ct_incoming);
		} else if (info.getCallType() == 7) { // 去电
			holder.ivType.setImageResource(R.drawable.icar_ic_ct_outgoing);
		} else if (info.getCallType() == 5) { // 未接
			holder.ivType.setImageResource(R.drawable.icar_ic_ct_miss);
		}

		holder.ivCall.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				/*
				 * if (MainActivity.bBlueToothStatus == false) { CharSequence
				 * str = mContext.getString(R.string.bt_unconn_tip);
				 * Toast.makeText(mContext, "蓝牙未连接啊大哥！",
				 * Toast.LENGTH_SHORT).show(); return; }
				 */
				if (mhandler != null) {
					Handler handler = CalllogActivity.getHandler();
					handler.sendMessage(handler.obtainMessage(CalllogActivity.HANDLER_EVENT_DIAL, info.getPhoneNum()));
				}
			}
		});

		return view;
	}

	public boolean isbDeleteState() {
		return bDeleteState;
	}

	public void setbDeleteState(boolean bDeleteState) {
		this.bDeleteState = bDeleteState;
	}

	public void SendMsg(Handler h, int what, int pos) {
		Message msg = h.obtainMessage();
		msg.arg1 = what;
		msg.arg2 = pos;
		h.sendMessage(msg);
	}

	class ViewHolder {
		CheckBox cbCheck;
		ImageView ivType;
		TextView tvName;
		TextView tvNumber;
		ImageView ivBt;
		TextView tvData;
		Button ivCall;
	}

	public String TimestamptoDate(String time) {

		String re_StrTime = "未知";
		String call_date = "未知";
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd HH:mm");
		Date date = null;
		try {
			date = sdf1.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 提取格式中的日期
		re_StrTime = sdf2.format(date);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Date curDate = new Date(System.currentTimeMillis());
		String today = formatter.format(curDate);
		call_date = formatter.format(date);

		if (today.equals(call_date)) {
			SimpleDateFormat sfd1 = new SimpleDateFormat("今天  hh:mm");
			re_StrTime = sfd1.format(date);
		}
		return re_StrTime;
	}

}
