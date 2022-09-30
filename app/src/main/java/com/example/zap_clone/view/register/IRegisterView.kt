package com.example.zap_clone.view.register

import com.example.zap_clone.util.ICallback

interface IRegisterView: ICallback {

    fun displayEmailError(emailError: Int?)
    fun displayRepPasswordError(repPasswordError: Int?)
    fun displayPasswordError(passwordError: Int?)
    fun showProgressBar(enabled: Boolean)
    fun openProfileActivity()

}