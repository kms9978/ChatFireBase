package com.martin.chatfirebase.ui
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import com.martin.chatfirebase.R
import com.martin.chatfirebase.databinding.ActivityLoginBinding
import com.martin.chatfirebase.ui.service.Key.Companion.DB_URL
import com.martin.chatfirebase.ui.service.Key.Companion.DB_USERS

class LoginActivity: AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        binding.loginBtn.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "이메일 또는 패스워드가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Firebase.auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    val currentUser = Firebase.auth.currentUser
                    if (task.isSuccessful && currentUser != null) {
                        val userId = currentUser.uid

                        Firebase.messaging.token.addOnCompleteListener {
                            val token = it.result
                            val user = mutableMapOf<String, Any>()
                            user["userId"] = userId // uid
                            user["username"] = email
                            user["fcmToken"] = token

                            Firebase.database(DB_URL).reference.child(DB_USERS).child(userId)
                                .updateChildren(user)

                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    } else {
                        Toast.makeText(this, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()
                    }

                }
        }
    }
}