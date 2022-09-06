package com.example.zap_clone.view.login

interface Login {


    fun displayEmailError(emailError: Int?)
    fun displayPasswordError(passwordError: Int?)
    fun showProgressBar(enabled: Boolean)
    fun openRegisterAcitvity()
}