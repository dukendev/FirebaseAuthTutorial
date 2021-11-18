package com.ysanjeet535.firebaseauthtutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        auth = Firebase.auth
        createRequest()

        val profiletext = findViewById<TextView>(R.id.textprofile)
        profiletext.text = auth.currentUser?.displayName

        val logout = findViewById<Button>(R.id.logoutbutton)
        logout.setOnClickListener {
            googleSignInClient.signOut()
            val singIntent = Intent(this,MainActivity::class.java)
            startActivity(singIntent)
            finish()
        }
    }

    private fun createRequest(){
        val gso = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("313644003906-fqs6p09pvmn1dstipcttq4it5a6jjajc.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
    }
}