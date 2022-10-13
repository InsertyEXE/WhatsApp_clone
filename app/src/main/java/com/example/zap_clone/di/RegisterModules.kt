package com.example.zap_clone.di

import com.example.zap_clone.view.register.model.IRegisterEmailCallback
import com.example.zap_clone.view.register.model.IRegisterEmailView
import com.example.zap_clone.view.register.model.IRegisterNameView
import com.example.zap_clone.view.register.viewmodel.RegisterEmailViewModel
import com.example.zap_clone.view.register.data.repositoryEmail.RegisterEmailRepository
import com.example.zap_clone.view.register.data.repositoryEmail.RegisterEmailRepositoryImp
import com.example.zap_clone.view.register.data.repositoryName.RegisterNameRepository
import com.example.zap_clone.view.register.data.repositoryName.RegisterNameRepositoryImp
import com.example.zap_clone.view.register.model.IRegisterNameCallback
import com.example.zap_clone.view.register.viewmodel.RegisterNameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val RegisterModule = module {

    viewModel { (view: IRegisterEmailView, callback: IRegisterEmailCallback) ->
        RegisterEmailViewModel(view, RegisterEmailRepository(RegisterEmailRepositoryImp(callback)))
    }

    viewModel{ (view: IRegisterNameView, callback: IRegisterNameCallback) ->
        RegisterNameViewModel(view, RegisterNameRepository(RegisterNameRepositoryImp(callback)))
    }
}