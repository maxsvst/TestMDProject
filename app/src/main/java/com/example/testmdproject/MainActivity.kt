package com.example.testmdproject

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_reg.*
import kotlinx.android.synthetic.main.fragment_reg.RegisterBut
import kotlinx.android.synthetic.main.fragment_reg.RegisterPassword
import kotlinx.android.synthetic.main.fragment_reg.RegisterUsername

class MainActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController: NavController = navHostFragment.navController


        val sharedPreferences: SharedPreferences = getSharedPreferences("shared Prefs", Context.MODE_PRIVATE)
        val savedUsername = sharedPreferences.getString("USERNAME_KEY", null)
        val savedPassword = sharedPreferences.getString("PASSWORD_KEY", null)

        if(savedUsername?.isNotEmpty() == true && savedPassword?.isNotEmpty() == true ) {
            navController.navigate(R.id.action_loginFragment_to_menuFragment)
        }
    }
}
