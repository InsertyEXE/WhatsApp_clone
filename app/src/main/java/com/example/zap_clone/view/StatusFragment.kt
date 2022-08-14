package com.example.zap_clone.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.zap_clone.R
import com.example.zap_clone.databinding.FragmentStatsBinding

class StatusFragment: Fragment(R.layout.fragment_stats) {

    private var binding: FragmentStatsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStatsBinding.bind(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}