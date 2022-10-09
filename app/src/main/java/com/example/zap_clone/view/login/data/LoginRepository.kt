package com.example.zap_clone.view.login.data

import com.example.zap_clone.model.User

class LoginRepository(private val repository: LoginRepositoryImp) {

    fun loginUser(email: String, password: String) = repository.loginUser(email, password)
}