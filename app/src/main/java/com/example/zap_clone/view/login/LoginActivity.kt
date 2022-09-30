package com.example.zap_clone.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zap_clone.databinding.ActivityLoginBinding
import com.example.zap_clone.util.TxtWatcher
import com.example.zap_clone.view.register.RegisterActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class LoginActivity : AppCompatActivity(), ILogin {

    private val viewModel: LoginViewModel by viewModel{
        parametersOf(this@LoginActivity)
    }

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            loginEdtEmail.addTextChangedListener(watcher)
            loginEdtEmail.addTextChangedListener(TxtWatcher {
                displayEmailError(null)
            })
            loginEdtPassword.addTextChangedListener(watcher)

            binding.loginBtnEnter.setOnClickListener {
                viewModel.login(binding.loginEdtEmail.text.toString(), binding.loginEdtPassword.text.toString())
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

//    override fun displayPasswordError(passwordError: Int?) {
//        binding.loginInputPassword.error = passwordError?.let { getString(R.string.password_error) }
//    }

    override fun showProgressBar(enabled: Boolean) {
        binding.loginBtnEnter.showProgressbar(enabled)
    }

    override fun openRegisterAcitvity() {
       startActivity(Intent(this, RegisterActivity::class.java))
    }
}