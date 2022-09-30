package com.example.zap_clone.view.register.repository

class RegisterRepository(private val repository: RegisterRepositoryImp) {

    suspend fun registerUser(email: String, password: String) = repository.registerUser(email, password)
}