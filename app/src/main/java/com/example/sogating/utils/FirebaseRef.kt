package com.example.sogating.utils

import com.google.firebase.Firebase
import com.google.firebase.database.database

class FirebaseRef {

    companion object {

        // Write a message to the database
        val database = Firebase.database
        val userinfoRef = database.getReference("userinfo")

    }
}