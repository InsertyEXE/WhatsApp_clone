package com.example.zap_clone.di

import com.example.zap_clone.view.login.ILogin
import com.example.zap_clone.view.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

//interface Login
//class LoginViewModel(val view: Login)
val LoginModule = module {

    viewModel { (view: ILogin) -> LoginViewModel(view) }
}