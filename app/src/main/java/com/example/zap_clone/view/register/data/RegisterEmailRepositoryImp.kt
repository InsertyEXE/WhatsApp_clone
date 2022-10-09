package com.example.zap_clone.view.register.data

import com.example.zap_clone.view.register.model.IRegisterEmailCallback
import com.example.zap_clone.R
import com.google.firebase.auth.FirebaseAuth

class RegisterEmailRepositoryImp(private val callback: IRegisterEmailCallback): IRegisterEmailRepo {

    override fun registerUser(email: String, password: String) {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    task.result.user!!.sendEmailVerification().addOnCompleteListener { sendEmail ->
                        callback.onComplete(false)
                        if (!sendEmail.isSuccessful){
                            task.result.user!!.delete().addOnCompleteListener{
                                callback.onFailure(R.string.failure_message)
                            }
                        }
                        else callback.onSucess(R.string.sucess_register)
                    }
                }
                else{
                    callback.onFailure(R.string.failure_message)
                    callback.onComplete(false)
                }
        }
    }
}