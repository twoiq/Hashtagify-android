package com.twoiq.hashtagify

import android.content.Context
import android.content.Intent
import android.content.res.TypedArray
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.util.AttributeSet
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by Mufaddal Makada on 2020-03-13.
 */
class CustomTextView : TextView {

    var clickIntent: Intent = Intent()
    var clickIntentBundleKey: String = "hash_tag"

    private var tagColor: Int = ContextCompat.getColor(context, R.color.colorBlue)

    private lateinit var hashTagSpans: ArrayList<IntArray>

    constructor(context: Context?) : super(context) {
        init(attrs = null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(attrs)
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(attrs)
    }

    override fun setText(text: CharSequence?, type: BufferType?) {
        hashTagSpans = getHashTagSpans(text.toString(), '#')
        val ss = SpannableString(text.toString())
        setHashTagSpans(ss, hashTagSpans)
        movementMethod = LinkMovementMethod.getInstance()
        super.setText(ss, type)
    }

    private fun init(attrs: AttributeSet?) {
        val a: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomEditText)
        tagColor = a.getColor(R.styleable.CustomEditText_tagColor, tagColor)
        a.recycle()
    }

    private fun getHashTagSpans(body: String, prefix: Char): ArrayList<IntArray> {
        val spans = ArrayList<IntArray>()
        val pattern: Pattern = Pattern.compile("$prefix\\w+")
        val matcher: Matcher = pattern.matcher(body)
        // Check all occurrences
        while (matcher.find()) {
            val currentSpan = IntArray(2)
            currentSpan[0] = matcher.start()
            currentSpan[1] = matcher.end()
            spans.add(currentSpan)
        }
        return spans
    }

    private fun setHashTagSpans(
        commentsContent: SpannableString,
        hashTagSpans: ArrayList<IntArray>
    ) {
        for (i in 0 until hashTagSpans.size) {
            val span = hashTagSpans[i]
            val hashTagStart = span[0]
            val hashTagEnd = span[1]
            commentsContent.setSpan(
                HashTagSpan(context, clickIntent, clickIntentBundleKey, tagColor),
                hashTagStart,
                hashTagEnd, 0
            )
        }
    }

    fun setTagColor(color: Int){
        tagColor = color
        setText(text)
    }
}