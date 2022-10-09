package com.example.zap_clone.view.register.model

import com.example.zap_clone.model.User


interface IRegisterNameCallback {

    fun onSucess(sucessMessage: Int?, user: User)
    fun onFailure(failureMessage: Int?)
    fun onComplete(progressBarEnabled: Boolean)
}