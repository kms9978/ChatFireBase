package com.martin.chatfirebase.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.martin.chatfirebase.R
import com.martin.chatfirebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userFragment = UserListFragment()
    private val chatListFragment = ChatListFragment()
    private val myPageFragment = MyPageFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val currentUser = Firebase.auth.currentUser
//
//        if (currentUser == null) {
//            // 로그인이 안되어있음
//            startActivity(Intent(this, LoginActivity::class.java))
//            finish()
//        }



        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.userList -> {
                    replaceFragment(userFragment)
                    supportActionBar?.title = ""
                    return@setOnItemSelectedListener true
                }
                R.id.ChatList -> {
                    replaceFragment(chatListFragment)
                    supportActionBar?.title = ""
                    return@setOnItemSelectedListener true
                }
                R.id.myPage -> {
                    replaceFragment(myPageFragment)
                    supportActionBar?.title = ""
                    return@setOnItemSelectedListener true
                }
                else -> {
                    return@setOnItemSelectedListener false
                }
            }
        }
        replaceFragment(userFragment)
        supportActionBar?.title = "friend"

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.frameLayout, fragment)
                commit()
            }

    }
}