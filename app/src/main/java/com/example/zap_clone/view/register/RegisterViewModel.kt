package com.example.zap_clone.view.register

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zap_clone.R
import com.example.zap_clone.view.register.repository.RegisterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(
    private var view: IRegisterView?,
    private val repository: RegisterRepository
) :
    ViewModel() {

    fun registerUser(email: String, password: String, repPassword: String) {
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = password.length > 5
        val isEqualPassword = password == repPassword

        if (!isEmailValid)
            view?.displayEmailError(R.string.email_error)

        if (!isPasswordValid)
            view?.displayPasswordError(R.string.password_error)

        if (!isEqualPassword)
            view?.displayRepPasswordError(R.string.repassword_error)

        if (isEmailValid && isPasswordValid && isEqualPassword) {
            view?.showProgressBar(true)
            viewModelScope.launch(Dispatchers.IO) {
                repository.registerUser(email, password)
            }
        }
    }
}
