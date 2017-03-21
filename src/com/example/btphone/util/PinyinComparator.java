package com.example.btphone.util;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Comparator;

import com.example.btphone.bean.ContactInfo;

//这个与pdi408的不同，用的是网上的拼音排序方法
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
		} else if (o2SortLetters.equals("#")) { // 当o1是以字母或汉字开头,o2不是
			i = 1;
		} else if (thisSortLetters.equals(o2SortLetters)) { // 当两者都是字母或汉字开头,并且首字母相等,
		// return this.isbIsletter()?1:0; //当o1是以字母开头放后面,汉字开头放前面

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

		} else { // 当两者首字母不相等时比较首字母

			i = thisSortLetters.compareTo(o2SortLetters);
			if (i == 0)
				i = i;
			else
				i = i > 0 ? 1 : -1;
		}

		return i;

	}*/
}