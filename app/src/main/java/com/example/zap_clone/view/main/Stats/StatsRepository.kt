package com.example.zap_clone.view.main.Stats

import com.example.zap_clone.model.User

class StatsRepository(private val repository: StatsRepositoryImp) {

    fun getUserInfos() = repository.getUserInfos()
}