package com.example.lab2.data

import android.util.Log
import com.example.lab2.domain.models.network.Company
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CompanyService {

    companion object {
        private const val TAG = "CompanyService"
    }

    private val db = Firebase.firestore

    fun fetchCompanyData(documentId: String): Task<List<Company>?> {
        val docRef = db.collection("companies").document(documentId)

        return docRef.get().continueWith { task ->
            if (task.isSuccessful) {
                val document = task.result
                if (document != null && document.exists()) {
                    Log.d(TAG, "Document exists: ${document.id}")
                    val companiesField = document.get("companies")
                    if (companiesField is List<*>) {
                        val gson = Gson()
                        val type = object : TypeToken<List<Company>>() {}.type
                        gson.fromJson<List<Company>>(gson.toJson(companiesField), type)
                    } else {
                        Log.e(TAG, "Companies field is not a List")
                        null
                    }
                } else {
                    Log.e(TAG, "Document does not exist")
                    null
                }
            } else {
                Log.e(TAG, "Task failed with exception: ", task.exception)
                null
            }
        }
    }
}
