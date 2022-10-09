package com.example.zap_clone.view.register.data

import com.example.zap_clone.model.User

interface IRegisterNameRepo {
    fun saveUserFirestore(user: User)
}