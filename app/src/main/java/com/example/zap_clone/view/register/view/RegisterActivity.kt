package com.example.zap_clone.view.register.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.example.zap_clone.R
import com.example.zap_clone.model.User
import com.example.zap_clone.view.main.MainActivity
import com.example.zap_clone.view.register.model.FragmentAttachListener
import com.example.zap_clone.view.register.view.RegisterEmailFragment.Companion.KEY_EMAIL

class RegisterActivity : AppCompatActivity(), FragmentAttachListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        replaceFragment(R.id.register_fragment_main, RegisterEmailFragment())
    }

    private fun replaceFragment(@IdRes id: Int, fragment: Fragment) {
        if (supportFragmentManager.findFragmentById(id) == null) {
            supportFragmentManager.beginTransaction().apply {
                add(id, fragment)
                commit()
            }

        } else {
            supportFragmentManager.beginTransaction().apply {
                replace(id, fragment)
                addToBackStack(null)
                commit()
            }

        }
    }

    override fun goToName(email: String) {
        val args = Bundle()
        args.putString(KEY_EMAIL, email)
        val fragment = RegisterNameFragment()
        fragment.arguments = args
        replaceFragment(R.id.register_fragment_main, fragment)
    }

    override fun goToMainScreen(user: User) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(MainActivity.KEY_USER, user)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

}