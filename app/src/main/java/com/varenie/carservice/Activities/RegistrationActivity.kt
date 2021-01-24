package com.varenie.carservice.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import androidx.databinding.DataBindingUtil
import com.varenie.carservice.R
import com.varenie.carservice.databinding.ActivityRegistrationBinding
import java.util.regex.Pattern

class RegistrationActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration)

        setupListeners()

        binding.btnReg.setOnClickListener {
            if (isValidate()) {
                startActivity(Intent(this, NavigationActivity::class.java))
            }
        }
    }

    //  Если все проверки пройдены успешно, то возвращает true
    private fun isValidate(): Boolean = validateUserName() && validateEmail() && validatePhone() && validatePassword() && validateConfirmPassword()


//  назначает листенеры ввода на все поля
    private fun setupListeners() {
        binding.tietFioReg.addTextChangedListener(TFValidationReg(binding.tietFioReg))
        binding.tietEmailReg.addTextChangedListener(TFValidationReg(binding.tietEmailReg))
        binding.tietPhoneReg.addTextChangedListener(TFValidationReg(binding.tietPhoneReg))
        binding.tietPassReg.addTextChangedListener(TFValidationReg(binding.tietPassReg))
        binding.tietConfirmPassReg.addTextChangedListener(TFValidationReg(binding.tietConfirmPassReg))
    }

//  Класс для обработки ввода в реальном времени
//  взято отсюда https://habr.com/ru/company/otus/blog/529886/
    inner class TFValidationReg(private val view: View): TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { }

        override fun afterTextChanged(s: Editable?) {
//          выбирает функцию проверки ввода в соответствии с конкретным полем
            when(view.id) {
                R.id.tiet_fio_reg -> {
                    validateUserName()
                }

                R.id.tiet_email_reg -> {
                    validateEmail()
                }

                R.id.tiet_phone_reg -> {
                    validatePhone()
                }

                R.id.tiet_pass_reg -> {
                    validatePassword()
                }

                R.id.tiet_confirm_pass_reg -> {
                    validateConfirmPassword()
                }

            }
        }

    }

//  til - TextInputLayout
//  tiet - TextInputEditText

//  Проверка на пустое поле имени
    private fun validateUserName(): Boolean {
        when {
            binding.tietFioReg.text.isNullOrBlank() -> {
                binding.tilFioReg.error = "Обязательное поле!"
                binding.tietFioReg.requestFocus()
                return false
            }
            else -> {
                binding.tilFioReg.isErrorEnabled = false
            }
        }

        return true
    }

//  Проверка на пустое поле
//  Проверка ввода на соответствие вида email
    private fun validateEmail(): Boolean {
        when {
            binding.tietEmailReg.text.isNullOrBlank() -> {
                binding.tilEmailReg.error = "Обязательное поле!"
                binding.tietEmailReg.requestFocus()
                return false
            }
            !isValidEmail(binding.tietEmailReg.text.toString()) -> {
                binding.tilEmailReg.error = "Введите корректный email"
                binding.tietEmailReg.requestFocus()
                return false
            }
            else -> {
                binding.tilEmailReg.isErrorEnabled = false
            }
        }

        return true
    }

//  Проверка на пустое поле
//  Проверка ввода на соответствие вида телефона
    private fun validatePhone(): Boolean {
        when {
            binding.tietPhoneReg.text.isNullOrBlank() -> {
                binding.tilPhoneReg.error = "Обязательное поле!"
                binding.tietPhoneReg.requestFocus()
                return false
            }
            !isValidPhone(binding.tietPhoneReg.text.toString()) -> {
                binding.tilPhoneReg.error = "Некорректный ввод номера телефона"
                binding.tietPhoneReg.requestFocus()
                return false
            }
            else -> {
                binding.tilPhoneReg.isErrorEnabled = false
            }
        }

       return true
    }

//  Проверка на пустое поле
//  Проверка на длину пароля не меньше 6 символов
//  Проверка на содержание чисел в пароле
//  Проверка на содержание разного регистра букв
//  Проверка на содержание специальных символов
    private fun validatePassword(): Boolean {
        when {
            binding.tietPassReg.text.isNullOrBlank() -> {
                binding.tilPassReg.error = "Обязательное поле!"
                binding.tietPassReg.requestFocus()
                return false
            }
            binding.tietPassReg.text.toString().length < 6 -> {
                binding.tilPassReg.error = "Пароль должен быть длиной не менее 6 символов"
                binding.tietPassReg.requestFocus()
                return false
            }
            !isContainNumbers(binding.tietPassReg.text.toString()) -> {
                binding.tilPassReg.error = "Пароль должен содержать хотя бы одну цифру"
                binding.tietPassReg.requestFocus()
                return false
            }
            !isStringLowerAndUpperCase(binding.tietPassReg.text.toString()) -> {
                binding.tilPassReg.error = "Пароль должен содержать буквы нижнего и верхнего регистра"
                binding.tietPassReg.requestFocus()
                return false
            }
            !isStringContainSpecialCharacter(binding.tietPassReg.text.toString()) -> {
                binding.tilPassReg.error = "Пароль должен содержать хотя бы один специальный символ"
                binding.tietPassReg.requestFocus()
                return false
            }
            else -> {
                binding.tilPassReg.isErrorEnabled = false
            }
        }

        return true
    }

    private fun validateConfirmPassword(): Boolean {
        when {
            binding.tietConfirmPassReg.text.isNullOrBlank() -> {
                binding.tilConfirmPassReg.error = "Обязательное поле!"
                binding.tietConfirmPassReg.requestFocus()
                return false
            }
            binding.tietConfirmPassReg.text.toString() != binding.tietPassReg.text.toString() -> {
                binding.tilConfirmPassReg.error = "Пароли должны совпадать!"
                binding.tietConfirmPassReg.requestFocus()
                return false
            }
            else -> {
                binding.tilConfirmPassReg.isErrorEnabled = false
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

//  Соджержит ли строка числа
    private fun isContainNumbers(password: String): Boolean {
        val pattern = Pattern.compile(".*\\d.*")
        val matcher = pattern.matcher(password)
        return matcher.matches()
    }

//  Содержит ли строка буквы нижнего и верхнего регистра
    private fun isStringLowerAndUpperCase(password: String): Boolean {
        val lowerCasePattern = Pattern.compile(".*[a-z].*")
        val upperCasePattern = Pattern.compile(".*[A-Z].*")

        val lowerCasePatterMatcher = lowerCasePattern.matcher(password)
        val upperCasePatterMatcher = upperCasePattern.matcher(password)

        return if (!lowerCasePatterMatcher.matches()) {
            false
        } else upperCasePatterMatcher.matches()
    }

//  Содержит ли строка специальные символы
    fun isStringContainSpecialCharacter(password: String): Boolean {
        val specialCharacterPattern = Pattern.compile("[^a-zA-Z0-9 ]")
        val specialCharacterMatcher = specialCharacterPattern.matcher(password)
        return specialCharacterMatcher.find()
    }
}
