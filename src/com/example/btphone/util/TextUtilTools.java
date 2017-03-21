package com.example.btphone.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;

public class TextUtilTools {
 
    /**
     * �ؼ��ָ�����ʾ
     * 
     * @param target  ��Ҫ�����Ĺؼ���
     * @param text       ��Ҫ��ʾ������
     * @return spannable �������Ľ�����ǵò�ҪtoString()������û��Ч��
     */
    public static SpannableStringBuilder highlight(String text, String target) {
        SpannableStringBuilder spannable = new SpannableStringBuilder(text);
        CharacterStyle span = null;
        target=target.replace("+", "").
        		replace("*", "").
        		replace("#", "");
        Pattern p = Pattern.compile(target);
        Matcher m = p.matcher(text);
        while (m.find()) {
            span = new ForegroundColorSpan(Color.BLUE);// ��Ҫ�ظ���
            spannable.setSpan(span, m.start(), m.end(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return spannable;
    }
     
    // ����
    // SpannableStringBuilder textString = TextUtilTools.highlight(item.getItemName(), KnowledgeActivity.searchKey);
    // vHolder.tv_itemName_search.setText(textString);
}
