package com.example.zap_clone.view.main.Stats


import com.example.zap_clone.model.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

class StatsRepositoryImp() {

    fun getUserInfos(): Task<DocumentSnapshot> {
        return FirebaseFirestore.getInstance().collection("USERS").document(FirebaseAuth.getInstance().currentUser?.uid.toString())
            .get().addOnSuccessListener {
                val name = it["name"]
                val profilePicture = it["profilePicture"]
                User(
                    FirebaseAuth.getInstance().currentUser?.uid.toString(),
                    name.toString(),
                    FirebaseAuth.getInstance().currentUser?.email.toString(),
                    profilePicture.toString()
                )
            }
    }
}