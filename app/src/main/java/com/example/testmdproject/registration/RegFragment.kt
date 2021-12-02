package com.example.testmdproject.registration

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.testmdproject.R
import kotlinx.android.synthetic.main.fragment_reg.view.*


class RegFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_reg, container, false)
        //Объявление setOnClickListener для кнопки "Регистрация"
        view.RegisterBut.setOnClickListener {
            if (dataIsValid(view)) {
                saveData(view)
                findNavController().navigate(R.id.action_regFragment_to_loginFragment)
            }
        }
        //Объявление setOnClickListener для кнопки "Уже етсь аккаунт?"
        view.RegisterToLoginBut.setOnClickListener {
            findNavController().navigate(R.id.action_regFragment_to_loginFragment)
        }

        return view

    }
    //Функция сохранения данных о пользователе с помощью shared references
    private fun saveData(view: View?){
        val userEmail = view?.RegisterEmail?.text.toString()
        val userName = view?.RegisterUsername?.text.toString()
        val userPassword = view?.RegisterPassword?.text.toString()

        val sharedPreferences = requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("EMAIL_KEY", userEmail)
            putString("USERNAME_KEY", userName)
            putString("PASSWORD_KEY", userPassword)
        }.apply()
        Toast.makeText(requireActivity(), "Регистрация прошла успешно", Toast.LENGTH_SHORT).show()
    }
    //Функция проверки на корректность ввода логина и пароля
    private fun dataIsValid(view: View?):Boolean{
        var check: Boolean = false

        val enteredEmail: String? = view?.RegisterEmail?.text.toString()
        val enteredUsername: String? = view?.RegisterUsername?.text.toString()
        val enteredPassword: String? = view?.RegisterPassword?.text.toString()
        val repeatedPassword: String? = view?.RegisterSecondPassword?.text.toString()
        if(enteredEmail?.isNotEmpty() == true && enteredUsername?.isNotEmpty() == true && enteredPassword?.isNotEmpty() == true && repeatedPassword?.isNotEmpty() == true){
            if(isValidEmail(enteredEmail)){
                if (enteredPassword?.length in 6..20){
                    if (enteredPassword == repeatedPassword){
                        check = true
                        return check
                    }
                    else{
                        Toast.makeText(requireActivity(), "Пароли не совпадают", Toast.LENGTH_SHORT).show()
                        return check
                    }
                }
                else{
                    Toast.makeText(requireActivity(), "Введён некорректный пароль", Toast.LENGTH_SHORT).show()
                    return check
                }
            }
            else{
                Toast.makeText(requireActivity(), "Введён некорректный Email", Toast.LENGTH_SHORT).show()
                return check
            }
        }
        else{
            Toast.makeText(requireActivity(), "Не все поля заполнены", Toast.LENGTH_SHORT).show()
            return check
        }
    }
    //Функция, котрая вызывается при проверке корректности ввода имейла
    private fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}