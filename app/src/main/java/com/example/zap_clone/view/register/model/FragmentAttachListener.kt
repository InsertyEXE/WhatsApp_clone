package com.example.zap_clone.view.register.model

import com.example.zap_clone.model.User

interface FragmentAttachListener {
    fun goToName(email: String)
    fun goToMainScreen(user: User)
}