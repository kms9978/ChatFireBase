package com.martin.chatfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.OnBackPressedCallback
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NewAccount1Activity : AppCompatActivity() {

    private val TAG = this.javaClass.simpleName
    // callback instance
    private val callback = object  : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            finish()
            Log.e(TAG,"back press")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newaccount1)
        supportActionBar?.hide()
        this.onBackPressedDispatcher.addCallback(this, callback)

        val goNew2 = findViewById<FloatingActionButton>(R.id.go_New2)
        val backBtn = findViewById<ImageButton>(R.id.back_Btn)

        goNew2.setOnClickListener {
            val intent = Intent(this@NewAccount1Activity, NewAccount2Activity::class.java)
            startActivity(intent)
        }

        backBtn.setOnClickListener {
            // Call the onBackPressed() method of the callback to handle the back button press
            callback.handleOnBackPressed()
        }
    }
}

