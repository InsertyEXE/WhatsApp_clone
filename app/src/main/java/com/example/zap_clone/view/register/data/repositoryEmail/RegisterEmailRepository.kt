package com.example.zap_clone.view.register.data.repositoryEmail

class RegisterEmailRepository(private val repository: RegisterEmailRepositoryImp) {

    fun registerUser(email: String, password: String) = repository.registerUser(email, password)
}