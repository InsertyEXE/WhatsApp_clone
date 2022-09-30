package com.example.zap_clone.view.login

import android.os.Handler
import android.os.Looper
import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.example.zap_clone.R

class LoginViewModel(private var view: ILogin): ViewModel() {

    fun login(email: String, password: String){
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        if (!isEmailValid) view.displayEmailError(R.string.email_error)
        else view.displayEmailError(null)

        if (isEmailValid){
            view.showProgressBar(true)

            Handler(Looper.getMainLooper()).postDelayed({view.showProgressBar(false)}, 2000)
        }

    }

    override fun onCleared() {
        super.onCleared()
    }
}
