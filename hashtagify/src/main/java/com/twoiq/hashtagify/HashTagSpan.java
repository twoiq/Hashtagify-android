package com.twoiq.hashtagify;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Mufaddal Makada on 2020-03-16.
 */
public class HashTagSpan extends ClickableSpan {

    private Context context;
    private Intent intent;
    private String bundleKey;
    private int tagColor;

    public HashTagSpan(Context ctx, Intent intent2, String bundleKey2, int tagColor2) {
        super();
        context = ctx;
        intent = intent2;
        bundleKey = bundleKey2;
        tagColor = tagColor2;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(ds.linkColor);
//        ds.setARGB(255, 30, 144, 255);
        ds.setARGB(Color.alpha(tagColor), Color.red(tagColor), Color.green(tagColor), Color.blue(tagColor));
    }

    @Override
    public void onClick(@NotNull View widget) {
        TextView tv = (TextView) widget;
        Spanned s = (Spanned) tv.getText();
        int start = s.getSpanStart(this);
        int end = s.getSpanEnd(this);
        String theWord = s.subSequence(start + 1, end).toString();
        intent.putExtra(bundleKey, theWord);
        context.startActivity(intent);
    }
}
