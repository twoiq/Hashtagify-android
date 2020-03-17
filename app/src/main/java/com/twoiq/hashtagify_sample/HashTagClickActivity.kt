package com.twoiq.hashtagify_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HashTagClickActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hash_tag_click)

        findViewById<TextView>(R.id.tvText).text =
            getString(R.string.clickText, intent.getStringExtra("tag"))
    }
}
