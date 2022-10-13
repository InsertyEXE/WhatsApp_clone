package com.example.zap_clone.view.register.data.repositoryName

import com.example.zap_clone.R
import com.example.zap_clone.model.User
import com.example.zap_clone.view.register.model.IRegisterNameCallback
import com.google.firebase.firestore.FirebaseFirestore

class RegisterNameRepositoryImp(private val callback: IRegisterNameCallback) : IRegisterNameRepo {
    override  fun saveUserFirestore(user: User) {
            FirebaseFirestore.getInstance().collection("USERS").document(user.id.toString())
                .set(user)
                .addOnCompleteListener {
                    callback.onComplete(false)
                    if (it.isSuccessful) callback.onSucess(R.string.welcome_user, user)
                    else callback.onFailure(R.string.failure_message)

                }
                .addOnFailureListener {
                    callback.onFailure(R.string.failure_message)
                    callback.onComplete(false)
                }
    }
}