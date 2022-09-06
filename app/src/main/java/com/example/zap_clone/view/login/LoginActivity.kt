package com.example.zap_clone.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.example.zap_clone.R
import com.example.zap_clone.databinding.ActivityLoginBinding
import com.example.zap_clone.util.TxtWatcher
import com.example.zap_clone.view.register.RegisterActivity

class LoginActivity : AppCompatActivity(), Login {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, LoginViewModelFactory(this)).get(LoginViewModel::class.java)

        binding.apply {
            loginEdtEmail.addTextChangedListener(watcher)
            loginEdtEmail.addTextChangedListener(TxtWatcher {
                displayEmailError(null)
            })
            loginEdtPassword.addTextChangedListener(watcher)

            loginBtnEnter.setOnClickListener {
                viewModel.login(loginEdtEmail.text.toString(), loginEdtPassword.text.toString())
            }

            loginTxtRegister.setOnClickListener {
                openRegisterAcitvity()
            }
        }

    }

    private val watcher = TxtWatcher {
        binding.loginBtnEnter.isEnabled = binding.loginEdtEmail.text.toString()
            .isNotEmpty() && binding.loginEdtPassword.text.toString().isNotEmpty()
    }

    override fun displayEmailError(emailError: Int?) {
        binding.loginInputEmail.error = emailError?.let { getString(it) }
    }

    override fun displayPasswordError(passwordError: Int?) {
//        binding.loginInputPassword.error = passwordError?.let { getString(R.string.password_error) }
    }

    override fun showProgressBar(enabled: Boolean) {
        binding.loginBtnEnter.showProgressbar(enabled)
    }

    override fun openRegisterAcitvity() {
       startActivity(Intent(this, RegisterActivity::class.java))
    }
}