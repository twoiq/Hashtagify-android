package com.twoiq.hashtagify_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import androidx.core.content.ContextCompat
import com.twoiq.hashtagify.CustomEditText

class SampleEditTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_edit_text)

        findViewById<Button>(R.id.btnChangeColor).setOnClickListener {
            findViewById<CustomEditText>(R.id.customEdt)
                .setTagColor(ContextCompat.getColor(this, R.color.colorRed))
        }
    }

}
