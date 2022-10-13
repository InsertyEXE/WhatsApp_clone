package com.example.zap_clone.view.register.data.repositoryEmail

interface IRegisterEmailRepo {
    fun registerUser(email: String, password: String)
}