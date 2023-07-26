package com.martin.chatfirebase.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.martin.chatfirebase.R

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        supportActionBar?.hide()

        val goLogin = findViewById<Button>(R.id.go_Login)
        val goNew1 = findViewById<Button>(R.id.go_New1)
        goLogin.setOnClickListener {
            val intent = Intent(this@StartActivity, LoginActivity::class.java)
            startActivity(intent)
        }
        goNew1.setOnClickListener {
            val intent = Intent(this@StartActivity, NewAccount1Activity::class.java)
            startActivity(intent)

        }
    }

}