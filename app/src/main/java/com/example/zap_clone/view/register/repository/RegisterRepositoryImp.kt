package com.example.zap_clone.view.register.repository

import com.example.zap_clone.util.ICallback
import com.example.zap_clone.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RegisterRepositoryImp(private val callback: ICallback): InterfaceRegisterRepo {

    override suspend fun registerUser(email: String, password: String) {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    task.result.user!!.sendEmailVerification().addOnCompleteListener { sendEmail ->
                        if (!sendEmail.isSuccessful){
                            task.result.user!!.delete().addOnCompleteListener{
                                callback.onComplete(false)
                            }
                        }
                        else {
                            callback.onSucess(R.string.sucess_register)
                            callback.onComplete(false)
                        }
                    }
                }
                else{
                    callback.failure(R.string.failure_message)
                    callback.onComplete(false)
                }
        }
    }
}