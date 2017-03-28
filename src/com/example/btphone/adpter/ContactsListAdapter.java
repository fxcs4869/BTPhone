package com.example.btphone.adpter;

import java.util.ArrayList;
import java.util.List;

import com.example.btphone.ContactsActivity;
import com.example.btphone.R;
import com.example.btphone.bean.ContactInfo;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ContactsListAdapter extends BaseAdapter {

	private List<ContactInfo> ContactInfoList = new ArrayList<ContactInfo>();
	private Context mContext;
	private boolean bDeleteState = false;
	private Handler mhandler;

	public ContactsListAdapter(Context context, Handler mhandler) {
		// TODO Auto-generated constructor stub
		this.mContext = context;
		this.mhandler = mhandler;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ContactInfoList.size();
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

	public boolean isbDeleteState() {
		return bDeleteState;
	}

	public void setbDeleteState(boolean bDeleteState) {
		this.bDeleteState = bDeleteState;
	}

	public void setData(List<ContactInfo> infoList) {
		this.ContactInfoList = infoList;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		View view = convertView;
		if (view == null) {
			holder = new ViewHolder();
			view = LayoutInflater.from(mContext).inflate(R.layout.contact_list_item, null);
			holder.tvIndex = (TextView) view.findViewById(R.id.index);
			holder.tvName = (TextView) view.findViewById(R.id.name);
			holder.ivCall = (Button) view.findViewById(R.id.dial);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		if (ContactInfoList != null & ContactInfoList.size() > 0) {// Ϊ��������±�Խ���쳣��bug��ӵ��ж�
			final ContactInfo info = ContactInfoList.get(position);
			holder.tvIndex.setText(position + 1 + ".");
			holder.tvName.setText(info.getName());
			holder.ivCall.setOnClickListener(new OnClickListener(){  //联系人列表的拨打电话
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					/*if (DialActivity.bHfpState == false) {  //bHfpState的更新有问题，暂时关闭
						Toast.makeText(mContext, "蓝牙未连接", Toast.LENGTH_SHORT).show();
						return;
					}*/
					if(mhandler!=null){
						Log.d("ContactActivity", "handler.sendMessage(msg);");
						Handler handler=ContactsActivity.getHandler();
						Message msg=handler.obtainMessage(ContactsActivity.HANDLER_EVENT_DIAL, info.getPhoneNum());
						handler.sendMessage(msg);
					}
					
				}
			});
			
		}
		return view;
	}

	public void SendMsg(Handler h, int what, int pos) {
		Message msg = h.obtainMessage();
		msg.arg1 = what;
		msg.arg2 = pos;
		h.sendMessage(msg);
	}

	class ViewHolder {

		TextView tvIndex;
		TextView tvName;
		Button ivCall;
		// ImageView ivBtPhone;
	}

}
