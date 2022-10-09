package com.example.zap_clone.view.register.data

interface IRegisterEmailRepo {
    fun registerUser(email: String, password: String)
}