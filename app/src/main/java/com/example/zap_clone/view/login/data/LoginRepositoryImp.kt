package com.example.zap_clone.view.login.data

import com.example.zap_clone.R
import com.example.zap_clone.model.User
import com.example.zap_clone.view.login.model.ILoginCallback
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class LoginRepositoryImp(private val callback: ILoginCallback) {

    fun loginUser(email: String, password: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val id = FirebaseAuth.getInstance().currentUser?.uid
                    FirebaseFirestore.getInstance().collection("USERS").document(id.toString())
                        .get().addOnSuccessListener { userFirestore ->
                            if (userFirestore.exists()) callback.onSucess(User(id, userFirestore.getString("name"), email, userFirestore.getString("profilePicture")))
                        }
                }
            }
            .addOnFailureListener {
                callback.onFailure(R.string.login_error)
            }
    }

}
