package com.martin.chatfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NewAccount2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newaccount2)
        supportActionBar?.hide()
        val goNew3 = findViewById<FloatingActionButton>(R.id.go_New3)
        goNew3.setOnClickListener {
            val intent = Intent(this@NewAccount2Activity,NewAccount3Activity::class.java)
            startActivity(intent)

        }
    }
}