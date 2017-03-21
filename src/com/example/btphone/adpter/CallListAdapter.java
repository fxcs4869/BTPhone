package com.example.btphone.adpter;

import java.util.ArrayList;
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

public class CallListAdapter extends BaseAdapter{
	private List<CallInfo> callInfoList = new ArrayList<CallInfo>();
	private Context mContext;
	private boolean bDeleteState = false;
	private Handler mhandler;
	
	public CallListAdapter(Context context,Handler mhandler) {
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
			//holder.cbCheck = (CheckBox) view.findViewById(R.id.check);
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
		holder.tvData.setText(info.getDate());
		if (info.getCallType() == 6) {                 //来电
			holder.ivType.setImageResource(R.drawable.icar_ic_ct_incoming);
		} else if (info.getCallType() == 7) {           //去电
			holder.ivType.setImageResource(R.drawable.icar_ic_ct_outgoing);
		} else if (info.getCallType() == 5) {          //未接
			holder.ivType.setImageResource(R.drawable.icar_ic_ct_miss);
		}
		
		/*if(bDeleteState){
			holder.cbCheck.setVisibility(View.VISIBLE);
			holder.cbCheck.setChecked(info.isbCheck());
		}else{
			holder.cbCheck.setVisibility(View.GONE);
		}
		
		holder.cbCheck.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SendMsg(mhandler,10, position);
			}
			
		});*/
		
		holder.ivCall.setOnClickListener(new OnClickListener() {  
			@Override
			public void onClick(View v) {
				/*if (MainActivity.bBlueToothStatus == false) {
					CharSequence str = mContext.getString(R.string.bt_unconn_tip);
					Toast.makeText(mContext, "蓝牙未连接啊大哥！", Toast.LENGTH_SHORT).show();
					return;
				}*/
                  if(mhandler!=null){
                	  Handler handler=CalllogActivity.getHandler();
                	  handler.sendMessage(handler.obtainMessage(CalllogActivity.HANDLER_EVENT_DIAL,info.getPhoneNum()));
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
}
