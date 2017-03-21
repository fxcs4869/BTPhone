package com.example.btphone.util;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Comparator;

import com.example.btphone.bean.ContactInfo;

//�����pdi408�Ĳ�ͬ���õ������ϵ�ƴ�����򷽷�
public class PinyinComparator implements Comparator<ContactInfo> {
	
	  Collator collator = Collator.getInstance();
	  
	  
	  @Override public int compare(ContactInfo lhs, ContactInfo rhs) {
	  CollationKey key1 = collator .getCollationKey(((ContactInfo)
	  lhs).getName()); CollationKey key2 = collator
	  .getCollationKey(((ContactInfo) rhs).getName()); return
	  key1.compareTo(key2); }
	 

	/*@Override
	public int compare(ContactInfo o1, ContactInfo o2) {

		String TAG = "ContactInfo";

		String thisSortLetters = o1.getSortLetters();
		String o2SortLetters = o2.getSortLetters();
		int i;

		if (thisSortLetters.equals("#")) {

			if (o2SortLetters.equals("#")) {

				i = 0;
			} else {
				i = -1;
			}
		} else if (o2SortLetters.equals("#")) { // ��o1������ĸ���ֿ�ͷ,o2����
			i = 1;
		} else if (thisSortLetters.equals(o2SortLetters)) { // �����߶�����ĸ���ֿ�ͷ,��������ĸ���,
		// return this.isbIsletter()?1:0; //��o1������ĸ��ͷ�ź���,���ֿ�ͷ��ǰ��

			if (o1.isbIsletter()) {

				if (o2.isbIsletter())
					i = 0;
				else
					i = 1;
			} else {
				if (o2.isbIsletter())
					i = -1;
				else
					i = 0;
			}

		} else { // ����������ĸ�����ʱ�Ƚ�����ĸ

			i = thisSortLetters.compareTo(o2SortLetters);
			if (i == 0)
				i = i;
			else
				i = i > 0 ? 1 : -1;
		}

		return i;

	}*/
}