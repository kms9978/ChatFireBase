package com.martin.chatfirebase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.martin.chatfirebase.databinding.FragmentChatlistBinding


class ChatListFragment : Fragment() {

    lateinit var binding: FragmentChatlistBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatlistBinding.inflate(inflater, container, false)

        // ActionBar 숨기기
        (activity as AppCompatActivity).supportActionBar?.hide()

        return binding.root
    }


}