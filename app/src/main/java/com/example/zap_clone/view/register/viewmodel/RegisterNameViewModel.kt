package com.example.zap_clone.view.register.viewmodel

import androidx.lifecycle.ViewModel
import com.example.zap_clone.R
import com.example.zap_clone.model.User
import com.example.zap_clone.view.register.model.IRegisterNameView
import com.example.zap_clone.view.register.data.repositoryName.RegisterNameRepository
import com.google.firebase.auth.FirebaseAuth

class RegisterNameViewModel(
    private val view: IRegisterNameView,
    private val repository: RegisterNameRepository
) : ViewModel() {

    fun registerUserFirestore(name: String, email: String) {
        if (name.isEmpty()) view.displayNameError(R.string.not_null)
        else{
            val user = User(FirebaseAuth.getInstance().currentUser?.uid, name, email, "")
            view.showProgressBar(true)
            repository.saveUserFirestore(user)
        }
    }
}