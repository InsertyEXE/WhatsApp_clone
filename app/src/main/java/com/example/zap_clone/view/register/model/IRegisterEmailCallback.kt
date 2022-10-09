package com.example.zap_clone.view.register.model

interface IRegisterEmailCallback {

    fun onSucess(sucessMessage: Int?)
    fun onFailure(failureMessage: Int?)
    fun onComplete(progressBarEnabled: Boolean)
}