package com.example.zap_clone.view.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.zap_clone.R
import com.example.zap_clone.databinding.FragmentStatsBinding
import com.example.zap_clone.model.User
import com.example.zap_clone.view.main.Stats.StatsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StatusFragment: Fragment(R.layout.fragment_stats) {

    private var binding: FragmentStatsBinding? = null
    private val viewModel: StatsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStatsBinding.bind(view)

        val args = arguments?.getParcelable<User>(KEY_USER_STATS)
        binding?.apply {
            if (args?.profilePicture.equals(""))
                statusPerfilImg.setImageResource(R.drawable.user_profile_placeholder)
        }


        viewModel.getUserInfos()


    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object{
        const val KEY_USER_STATS = "key_user_stats"
    }

}