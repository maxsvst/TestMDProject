package com.example.testmdproject.Menu

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.testmdproject.R
import kotlinx.android.synthetic.main.fragment_menu.view.*
import kotlinx.android.synthetic.main.fragment_reg.view.*


class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_menu, container, false)
        //Объявление setOnClickListener для кнопки выйти с очисткой данных текущего пользователя
        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_loginFragment)
            val preferences = requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = preferences.edit()
            editor.clear().commit()
        }

        return view

    }

}
