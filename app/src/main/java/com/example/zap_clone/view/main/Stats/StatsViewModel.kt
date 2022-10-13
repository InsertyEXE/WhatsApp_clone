package com.example.zap_clone.view.main.Stats

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zap_clone.model.User

class StatsViewModel(private val repository: StatsRepository): ViewModel() {

    val profilePicture = MutableLiveData<String>()

    fun getUserInfos(){
        repository.getUserInfos()
    }


}