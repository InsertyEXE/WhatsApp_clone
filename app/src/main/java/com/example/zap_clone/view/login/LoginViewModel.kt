package com.example.zap_clone.view.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.example.zap_clone.R
import com.example.zap_clone.view.login.data.LoginRepository
import com.example.zap_clone.view.login.model.ILoginView

class LoginViewModel(private var view: ILoginView, private val repository: LoginRepository): ViewModel() {

    fun login(email: String, password: String){
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        if (!isEmailValid) view.displayEmailError(R.string.email_error)
        if (isEmailValid){
            view.showProgressBar(true)
            repository.loginUser(email, password)
        }

    }
}
