package com.example.btphone.adpter;

import java.util.ArrayList;
import java.util.List;

import com.example.btphone.R;
import com.example.btphone.bean.ContactInfo;
import com.example.btphone.util.TextUtilTools;
import com.example.btphone.widget.AlwaysMarqueeTextView;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DialerListAdapter extends BaseAdapter {

	private List<ContactInfo> ContactInfoList = new ArrayList<ContactInfo>();
	private Context mContext;

	private String searchKey = "1";

	public DialerListAdapter(Context context) {
		// TODO Auto-generated constructor stub
		this.mContext = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ContactInfoList.size();
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

	public void setData(List<ContactInfo> infoList) {
		this.ContactInfoList = infoList;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		View view = convertView;
		if (view == null) {
			holder = new ViewHolder();
			LayoutInflater inflater = LayoutInflater.from(mContext);
			view = inflater.inflate(R.layout.dialer_list_item_layout, null);
			holder.tvName = (AlwaysMarqueeTextView) view.findViewById(R.id.caller_name);
			holder.tvNumber = (TextView) view.findViewById(R.id.caller_number);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		final ContactInfo info = ContactInfoList.get(position);
		holder.tvName.setText(info.getName());

		SpannableStringBuilder textString = TextUtilTools.highlight(info.getPhoneNum(), searchKey);
		holder.tvNumber.setText(textString);
		return view;
	}

	class ViewHolder {
		AlwaysMarqueeTextView tvName;
		TextView tvNumber;
	}

}
