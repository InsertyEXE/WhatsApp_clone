package com.example.zap_clone.view.login.model

import com.example.zap_clone.model.User

interface ILoginView : ILoginCallback{


    fun displayEmailError(emailError: Int?)
    fun showProgressBar(enabled: Boolean)
    fun openRegisterAcitvity()
    fun openMainScreen(user: User)

}