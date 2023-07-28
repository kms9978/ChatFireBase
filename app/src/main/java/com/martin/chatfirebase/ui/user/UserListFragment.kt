package com.martin.chatfirebase.ui.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.martin.chatfirebase.databinding.FragmentMypageBinding
import com.martin.chatfirebase.databinding.FragmentUserlistBinding

class UserListFragment : Fragment() {

    lateinit var binding: FragmentUserlistBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserlistBinding.inflate(inflater, container, false)

        // ActionBar 숨기기
        (activity as AppCompatActivity).supportActionBar?.hide()

        return binding.root
    }


}