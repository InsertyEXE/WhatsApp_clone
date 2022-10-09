package com.example.zap_clone.di

import com.example.zap_clone.view.login.model.ILoginView
import com.example.zap_clone.view.login.LoginViewModel
import com.example.zap_clone.view.login.data.LoginRepository
import com.example.zap_clone.view.login.data.LoginRepositoryImp
import com.example.zap_clone.view.login.model.ILoginCallback
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val LoginModule = module {

    viewModel { (view: ILoginView, callback: ILoginCallback) -> LoginViewModel(view, LoginRepository(LoginRepositoryImp(callback))) }
}