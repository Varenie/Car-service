package com.varenie.carservice.Fragments

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.varenie.carservice.R
import com.varenie.carservice.databinding.FragmentUserInfoBinding


class UserInfoFragment : Fragment() {
    lateinit var binding: FragmentUserInfoBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_info, container, false)

        setupListeners()

        binding.btnConfirmChanges.setOnClickListener {
            if (isValid()) {
                Navigation.findNavController(it).navigate(R.id.action_userInfo_to_account)
            }
        }
        return binding.root
    }

    private fun setupListeners() {
        binding.tietFioChange.addTextChangedListener(TFValidationUser(binding.tietFioChange))
        binding.tietEmailChange.addTextChangedListener(TFValidationUser(binding.tietEmailChange))
        binding.tietPhoneChange.addTextChangedListener(TFValidationUser(binding.tietPhoneChange))
    }

    private fun isValid() = validateUserName() && validateEmail() && validatePhone()

    inner class TFValidationUser(private val view: View): TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {
            when(view.id) {
                R.id.tiet_fio_change -> {
                    validateUserName()
                }

                R.id.tiet_email_change -> {
                    validateEmail()
                }

                R.id.tiet_phone_change -> {
                    validatePhone()
                }
            }
        }

    }

//  Проверка на пустое поле имени
    private fun validateUserName(): Boolean {
        when {
            binding.tietFioChange.text.isNullOrBlank() -> {
                binding.tilFioChange.error = "Обязательное поле!"
                binding.tietFioChange.requestFocus()
                return false
            }
            else -> {
                binding.tilFioChange.isErrorEnabled = false
            }
        }

        return true
    }

//  Проверка на пустое поле
//  Проверка ввода на соответствие вида email
    private fun validateEmail(): Boolean {
        when {
            binding.tietEmailChange.text.isNullOrBlank() -> {
                binding.tilEmailChange.error = "Обязательное поле!"
                binding.tietEmailChange.requestFocus()
                return false
            }
            !isValidEmail(binding.tietEmailChange.text.toString()) -> {
                binding.tilEmailChange.error = "Введите корректный email"
                binding.tietEmailChange.requestFocus()
                return false
            }
            else -> {
                binding.tilEmailChange.isErrorEnabled = false
            }
        }

        return true
    }

//  Проверка на пустое поле
//  Проверка ввода на соответствие вида телефона
    private fun validatePhone(): Boolean {
        when {
            binding.tietPhoneChange.text.isNullOrBlank() -> {
                binding.tilPhoneChange.error = "Обязательное поле!"
                binding.tietPhoneChange.requestFocus()
                return false
            }
            !isValidPhone(binding.tietPhoneChange.text.toString()) -> {
                binding.tilPhoneChange.error = "Некорректный ввод номера телефона"
                binding.tietPhoneChange.requestFocus()
                return false
            }
            else -> {
                binding.tilPhoneChange.isErrorEnabled = false
            }
        }

        return true
    }

//  Соответствие строки виду email
    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

//  Соответствие строки виду номера телефона
    private fun isValidPhone(phone: String): Boolean {
        return Patterns.PHONE.matcher(phone).matches()
    }
}