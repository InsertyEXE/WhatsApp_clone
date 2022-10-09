package com.example.zap_clone.view.register.model

interface IRegisterEmailView: IRegisterEmailCallback {

    fun displayEmailError(emailError: Int?)
    fun displayRepPasswordError(repPasswordError: Int?)
    fun displayPasswordError(passwordError: Int?)
    fun showProgressBar(enabled: Boolean)
    fun goToName(email: String)

}