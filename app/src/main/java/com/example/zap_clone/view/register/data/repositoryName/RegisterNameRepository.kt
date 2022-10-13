package com.example.zap_clone.view.register.data.repositoryName

import com.example.zap_clone.model.User

class RegisterNameRepository(private val repository: RegisterNameRepositoryImp) {

     fun saveUserFirestore(user: User) = repository.saveUserFirestore(user)

}