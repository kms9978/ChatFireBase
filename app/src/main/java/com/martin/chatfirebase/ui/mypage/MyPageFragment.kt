package com.martin.chatfirebase.ui.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.martin.chatfirebase.databinding.FragmentChatlistBinding
import com.martin.chatfirebase.databinding.FragmentMypageBinding


class MyPageFragment : Fragment() {

    lateinit var binding: FragmentMypageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMypageBinding.inflate(inflater, container, false)

        // ActionBar 숨기기
        (activity as AppCompatActivity).supportActionBar?.hide()

        return binding.root
    }



}