package com.wgf.intentapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {

    val TAG = SubActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        Log.d(TAG, ">> SubActivity onCreate")

        textView1.text = intent.getStringExtra("form1")
        textView2.text = "${intent.getIntExtra("form2", 0)}"

        buttonEnd.setOnClickListener{
            val returnIntent = Intent()
            returnIntent.putExtra("returnValue", editMessage.text.toString())
            setResult(Activity.RESULT_OK, returnIntent)
            Log.d(TAG, ">> buttonEnd Click")
            finish()
        }
    }
}