package com.example.zap_clone.di

import com.example.zap_clone.util.ICallback
import com.example.zap_clone.view.register.IRegisterView
import com.example.zap_clone.view.register.RegisterViewModel
import com.example.zap_clone.view.register.repository.RegisterRepository
import com.example.zap_clone.view.register.repository.RegisterRepositoryImp
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val RegisterModule = module {

    viewModel { (view: IRegisterView, callback: ICallback) ->
        RegisterViewModel(view, RegisterRepository(RegisterRepositoryImp(callback)))
    }
}