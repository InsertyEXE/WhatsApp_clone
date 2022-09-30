package com.example.zap_clone.view.register.repository

interface InterfaceRegisterRepo {
    suspend fun registerUser(email: String, password: String)
}