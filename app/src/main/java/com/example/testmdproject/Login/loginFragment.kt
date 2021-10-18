package com.example.testmdproject

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_reg.view.*

class LoginFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_login, container, false)
        //Объявление setOnClickListener для кнопки "Логин"
        view.LoginBut.setOnClickListener {
            if(checkSharedData(view) && dataIsValid(view)) {
                Toast.makeText(requireActivity(), "Вы успешно вошли", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_loginFragment_to_menuFragment)
            }
        }
        //Объявление setOnClickListener для кнопки "Ещё нет аккаунта?"
        view.LoginToRegisterBut.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_regFragment)
        }
        return view

    }
    //Функция проверки на корректность ввода логина и пароля
    private fun dataIsValid(view: View?):Boolean {
        var check: Boolean = false

        val enteredUsername: String = view?.LoginUsername?.text.toString()
        val enteredPassword: String = view?.LoginPassword?.text.toString()

        if (enteredUsername.isNotEmpty() && enteredPassword.isNotEmpty()) {
            if (enteredPassword.length in 6..20) {
                check = true
                return check
            } else {
                Toast.makeText(requireActivity(), "Введён некорректный пароль", Toast.LENGTH_SHORT)
                    .show()
                return check
            }
        } else {
            Toast.makeText(requireActivity(), "Не все поля заполнены", Toast.LENGTH_SHORT)
                .show()
            return check
        }
    }
    //Проверка на совпадение введённых данных с сохранёнными для осуществления входа
    private fun checkSharedData(view: View?): Boolean {

        var checked: Boolean = false

        val sharedPreferences: SharedPreferences = requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedUsername = sharedPreferences.getString("USERNAME_KEY", null)
        val savedPassword = sharedPreferences.getString("PASSWORD_KEY", null)

        val enteredUsername: String? = view?.LoginUsername?.text.toString()
        val enteredPassword: String? = view?.LoginPassword?.text.toString()

        if (savedUsername == enteredUsername && savedPassword == enteredPassword) {
            checked = true
            return checked
        } else {
            Toast.makeText(requireActivity(), "Такое Имя пользователя/Пароль не найден", Toast.LENGTH_SHORT).show()
            return checked
        }
    }
}


