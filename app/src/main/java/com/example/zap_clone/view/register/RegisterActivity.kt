package com.example.zap_clone.view.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.zap_clone.PerfilActivity
import com.example.zap_clone.databinding.ActivityRegisterBinding
import com.example.zap_clone.util.ICallback
import com.example.zap_clone.util.TxtWatcher
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class RegisterActivity : AppCompatActivity(), IRegisterView {

    private val viewModel: RegisterViewModel by viewModel {
        parametersOf(this@RegisterActivity, this@RegisterActivity)
    }

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            registerEdtEmail.addTextChangedListener(watcher)
            registerEdtEmail.addTextChangedListener(TxtWatcher {
                displayEmailError(null)
            })

            registerEdtPassword.addTextChangedListener(watcher)
            registerEdtPassword.addTextChangedListener(TxtWatcher {
                displayPasswordError(null)
            })

            registerEdtReptPassword.addTextChangedListener(watcher)
            registerEdtReptPassword.addTextChangedListener(TxtWatcher {
                displayRepPasswordError(null)
            })

            registerBtn.setOnClickListener {
                viewModel.registerUser(
                    registerEdtEmail.text.toString(),
                    registerEdtPassword.text.toString(),
                    registerEdtReptPassword.text.toString()
                )
            }
        }

    }

    private val watcher = TxtWatcher {
        binding.apply {
            registerBtn.isEnabled =
                registerEdtEmail.text.toString().isNotEmpty() && registerEdtPassword.text.toString()
                    .isNotEmpty() && registerEdtReptPassword.text.toString().isNotEmpty()
        }
    }

    override fun displayEmailError(emailError: Int?) {
        binding.registerInputEmail.error = emailError?.let { getString(it) }
    }

    override fun displayRepPasswordError(repPasswordError: Int?) {
        binding.registerInputReptPassword.error = repPasswordError?.let { getString(it) }
    }

    override fun displayPasswordError(passwordError: Int?) {
        binding.registerInputPassword.error = passwordError?.let { getString(it) }
    }

    override fun showProgressBar(enabled: Boolean) {
        binding.registerBtn.showProgressbar(enabled)
    }

    override fun openProfileActivity() {
        startActivity(Intent(this, PerfilActivity::class.java))
    }

    override fun onSucess(sucessMessage: Int?) {
        sucessMessage?.let { Toast.makeText(this, it, Toast.LENGTH_LONG).show() }
        openProfileActivity()
    }

    override fun failure(failureMessage: Int?) {
        failureMessage?.let { Toast.makeText(this, it, Toast.LENGTH_LONG).show() }
    }

    override fun onComplete(complete: Boolean) {
        showProgressBar(complete)
    }

}