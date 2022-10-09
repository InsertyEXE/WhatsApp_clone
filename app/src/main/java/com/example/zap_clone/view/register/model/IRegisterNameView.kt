package com.example.zap_clone.view.register.model

import com.example.zap_clone.model.User


interface IRegisterNameView: IRegisterNameCallback {

    fun displayNameError(nameError: Int?)
    fun showProgressBar(enabled: Boolean)
    fun goToMainScreen(user: User)

}