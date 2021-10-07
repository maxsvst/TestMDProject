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

    }
}
