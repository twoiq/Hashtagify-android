package com.twoiq.hashtagify

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.text.Editable
import android.text.Spannable
import android.text.Spanned
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import android.util.Log
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText

/**
 * Created by Mufaddal Makada on 2020-03-13.
 */
class CustomTextInputEditText : TextInputEditText, TextWatcher {

    private var defaultColor: Int = ContextCompat.getColor(context, R.color.colorBlack)
    private var tagColor: Int = ContextCompat.getColor(context, R.color.colorBlue)

    private lateinit var mspanable: Spannable

    constructor(context: Context?) : super(context){
        init(attrs = null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        init(attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){
        init(attrs)
    }

    override fun setTextColor(color: Int) {
        defaultColor = color
        super.setTextColor(color)
    }

    @SuppressLint("CustomViewStyleable")
    private fun init(attrs: AttributeSet?) {
        mspanable = this.text!!
        val a: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomEditText)
        tagColor = a.getColor(R.styleable.CustomEditText_tagColor, tagColor)
        defaultColor = a.getColor(R.styleable.CustomEditText_android_textColor, defaultColor)
        a.recycle()
        addTextChangedListener(this)
    }

    private fun changeTheColor(s: String, start: Int) {
        mspanable.setSpan(
            ForegroundColorSpan(tagColor),
            start,
            start + s.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    private fun changeTheColor2(s: String, start: Int) {
        mspanable.setSpan(
            ForegroundColorSpan(defaultColor),
            start,
            start + s.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    override fun onTextChanged(
        charSequence: CharSequence,
        i: Int,
        i1: Int,
        i2: Int
    ) {
        try {
            val fullStr = charSequence.toString()
            val strArray =
                text.toString().split("((?<= )|(?= )|\\r?\\n)".toRegex())
            var customStr = ""
            for (str in strArray) {
                if (str.length > 1 && str.startsWith("#") && str[1].isLetterOrDigit()) {
                    changeTheColor(str, fullStr.indexOf(str[0], customStr.length, false))
                } else {
                    if (str.trim().isNotEmpty()) {
                        changeTheColor2(
                            str,
                            fullStr.indexOf(str[0], customStr.length, false)
                        )
                    }
                }
                customStr += str
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("Logger", e.message.toString())
        }
    }

    override fun afterTextChanged(p0: Editable?) {
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    fun setTagColor(color: Int){
        tagColor = color
        onTextChanged(charSequence = text.toString(), i = text.toString().length, i1 = text.toString().length.minus(1), i2 = text.toString().length)
    }
}