package com.example.zap_clone.view.register.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.zap_clone.R
import com.example.zap_clone.databinding.FragmentRegisterNameBinding
import com.example.zap_clone.model.User
import com.example.zap_clone.util.TxtWatcher
import com.example.zap_clone.view.main.MainActivity
import com.example.zap_clone.view.main.MainActivity.Companion.KEY_USER
import com.example.zap_clone.view.register.model.FragmentAttachListener
import com.example.zap_clone.view.register.model.IRegisterNameView
import com.example.zap_clone.view.register.view.RegisterEmailFragment.Companion.KEY_EMAIL
import com.example.zap_clone.view.register.viewmodel.RegisterNameViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class RegisterNameFragment : Fragment(R.layout.fragment_register_name), IRegisterNameView {

    private var binding: FragmentRegisterNameBinding? = null
    private var fragmentAttachListener: FragmentAttachListener? = null

    private val viewmodel: RegisterNameViewModel by viewModel {
        parametersOf(
            this@RegisterNameFragment, this@RegisterNameFragment
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterNameBinding.bind(view)

        val email = arguments!!.getString(KEY_EMAIL)
            ?: throw IllegalArgumentException("Email não encontrado")

        binding?.apply {
            registerEdtName.addTextChangedListener(watcher)
            registerEdtName.addTextChangedListener(TxtWatcher {
                displayNameError(null)
            })

            registerBtn.setOnClickListener {
                viewmodel.registerUserFirestore(registerEdtName.text.toString(), email)
            }
        }
    }

    private val watcher = TxtWatcher {
        binding?.registerBtn?.isEnabled = binding?.registerEdtName?.text?.isNotEmpty() == true
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAttachListener) {
            fragmentAttachListener = context
        }
    }

    override fun displayNameError(nameError: Int?) {
        binding?.registerInputName?.error = nameError?.let { getString(nameError) }
    }

    override fun showProgressBar(enabled: Boolean) {
        binding?.registerBtn?.showProgressbar(enabled)
    }

    override fun goToMainScreen(user: User) {
        fragmentAttachListener?.goToMainScreen(user)
    }


    override fun onSucess(sucessMessage: Int?, user: User) {
        sucessMessage?.let {
            Toast.makeText(requireContext(), getString(it, user.name), Toast.LENGTH_LONG).show()
            goToMainScreen(user)
        }
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
}