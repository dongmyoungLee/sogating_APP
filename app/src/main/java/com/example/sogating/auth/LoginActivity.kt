package com.example.sogating.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sogating.MainActivity
import com.example.sogating.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {

    private val TAG = "LoginActivity"

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        // Initialize Firebase Auth
        auth = Firebase.auth

        val email = findViewById<TextInputEditText>(R.id.emailArea)
        val pwd = findViewById<TextInputEditText>(R.id.passwordArea)
        val loginBtn = findViewById<Button>(R.id.loginBtn)


        loginBtn.setOnClickListener {
            auth.signInWithEmailAndPassword(email.text.toString(), pwd.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this, "실패", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}