package com.example.zap_clone.view.register.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.zap_clone.R
import com.example.zap_clone.databinding.FragmentRegisterEmailBinding
import com.example.zap_clone.util.TxtWatcher
import com.example.zap_clone.view.register.model.FragmentAttachListener
import com.example.zap_clone.view.register.model.IRegisterEmailView
import com.example.zap_clone.view.register.viewmodel.RegisterEmailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class RegisterEmailFragment : Fragment(R.layout.fragment_register_email),
    IRegisterEmailView {

    private var binding: FragmentRegisterEmailBinding? = null
    private var fragmentAttachListener: FragmentAttachListener? = null

    private val viewModel: RegisterEmailViewModel by viewModel {
        parametersOf(this@RegisterEmailFragment, this@RegisterEmailFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterEmailBinding.bind(view)
        binding?.apply {
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
        binding?.apply {
            registerBtn.isEnabled =
                registerEdtEmail.text.toString().isNotEmpty() && registerEdtPassword.text.toString()
                    .isNotEmpty() && registerEdtReptPassword.text.toString().isNotEmpty()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAttachListener) {
            fragmentAttachListener = context
        }
    }

    override fun displayEmailError(emailError: Int?) {
        binding?.registerInputEmail?.error = emailError?.let { getString(it) }
    }

    override fun displayRepPasswordError(repPasswordError: Int?) {
        binding?.registerInputReptPassword?.error = repPasswordError?.let { getString(it) }
    }

    override fun displayPasswordError(passwordError: Int?) {
        binding?.registerInputPassword?.error = passwordError?.let { getString(it) }
    }

    override fun showProgressBar(enabled: Boolean) {
        binding?.registerBtn?.showProgressbar(enabled)
    }

    override fun goToName(email: String) {
        fragmentAttachListener?.goToName(email)
    }

    override fun onSucess(sucessMessage: Int?) {
        sucessMessage?.let { goToName(binding?.registerEdtEmail?.text.toString()) }
    }

    override fun onFailure(failureMessage: Int?) {
        failureMessage?.let { Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show() }
    }

    override fun onComplete(progressBarEnabled: Boolean) {
        showProgressBar(progressBarEnabled)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
        fragmentAttachListener = null
    }

    companion object {
        const val KEY_EMAIL = "key_email"
    }
}
