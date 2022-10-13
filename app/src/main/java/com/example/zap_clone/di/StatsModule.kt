package com.example.zap_clone.di

import com.example.zap_clone.view.main.Stats.StatsRepository
import com.example.zap_clone.view.main.Stats.StatsRepositoryImp
import com.example.zap_clone.view.main.Stats.StatsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val StatsModule = module {

    viewModel{
        StatsViewModel(StatsRepository((StatsRepositoryImp())))
    }
}