package com.wgf.intentapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, ">> onCreate")

        val intent = Intent(this, SubActivity::class.java)
        intent.putExtra("form1", "hello bundle!")
        intent.putExtra("form2", 2020)

        buttonStart.setOnClickListener{
            Log.d(TAG, ">> buttonStart Clcik")
            startActivityForResult(intent, 99)}
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.d(TAG, ">> onActivityResult")
        if(resultCode == Activity.RESULT_OK) {
            when(requestCode) {
                99 -> {
                    val message = data?.getStringExtra("returnValue")
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}