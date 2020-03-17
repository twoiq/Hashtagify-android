package com.twoiq.hashtagify_sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnEdt).setOnClickListener {
            val intent = Intent(this, SampleEditTextActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnTiet).setOnClickListener {
            val intent = Intent(this, SampleTextInputEditTextActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnTv).setOnClickListener {
            val intent = Intent(this, SampleTextViewActivity::class.java)
            startActivity(intent)
        }
    }
}
