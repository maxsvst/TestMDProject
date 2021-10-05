package com.example.testmdproject

import android.app.SearchManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginlayout)

        val textView: TextView = findViewById(R.id.LoginUsername)

        val button: Button = findViewById(R.id.LoginBut)

    //      val regTextView: TextView = findViewById(R.id.RegisterUsername)

//        val regButton: Button = findViewById(R.id.RegisterBut)

//        val landLoginButton: Button = findViewById(R.id.LandLoginBut)

//        val landTextView: TextView = findViewById(R.id.LandLoginUsername)

        button.setOnClickListener{
            textView.text = "You click login"
        }

//        regButton.setOnClickListener{
//            regTextView.text = "jopa"
//        }
    }
}