package com.example.zap_clone.view.login.model

import com.example.zap_clone.model.User

interface ILoginCallback {
    fun onSucess(user: User)
    fun onFailure(failureMessage: Int?)
}