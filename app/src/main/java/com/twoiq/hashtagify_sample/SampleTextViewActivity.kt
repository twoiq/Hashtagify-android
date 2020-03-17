package com.twoiq.hashtagify_sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import com.twoiq.hashtagify.CustomEditText
import com.twoiq.hashtagify.CustomTextView

class SampleTextViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_text_view)

        val edt = findViewById<CustomEditText>(R.id.customEdt)
        val tv = findViewById<CustomTextView>(R.id.tvText)
        val intent = Intent(this, HashTagClickActivity::class.java)
        tv.clickIntent = intent
        tv.clickIntentBundleKey = "tag"

        findViewById<Button>(R.id.btnUpdateTv).setOnClickListener {
            tv.text = edt.text
        }

        findViewById<Button>(R.id.btnChangeColor).setOnClickListener {
            tv.setTagColor(ContextCompat.getColor(this, R.color.colorRed))
        }
    }
}
