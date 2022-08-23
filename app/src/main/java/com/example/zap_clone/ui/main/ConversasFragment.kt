package com.example.zap_clone.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.zap_clone.R
import com.example.zap_clone.databinding.FragmentConversationsBinding

class ConversasFragment: Fragment(R.layout.fragment_conversations) {

    private var binding: FragmentConversationsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentConversationsBinding.bind(view)


    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}