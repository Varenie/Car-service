package com.varenie.carservice.Adapters

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.varenie.carservice.R
import com.varenie.carservice.databinding.RecyclerItemCarInfoBinding
import java.util.*
import java.util.regex.Pattern


class CarInfoAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var binding: RecyclerItemCarInfoBinding

    val labels = arrayOf(
            "Гос номер",
            "Марка",
            "Модель",
            "Цвет машины",
            "Номер модели",
            "Номер двигателя",
            "Тип двигателя",
            "Тип трансмиссии"
    )

    override fun getItemViewType(position: Int): Int {
        if (position == 7 || position == 6) {
            return 0
        }
        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        if (viewType == 0) {
            val view = inflater.inflate(R.layout.recycler_item_transmission, parent, false)
            return TransmissionHolder(view)
        }

        val view = inflater.inflate(R.layout.recycler_item_car_info, parent, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.recycler_item_car_info, parent, false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TransmissionHolder -> holder.bind(position)
            is BaseViewHolder -> holder.bind(position, labels)
        }
    }

    override fun getItemCount(): Int {
        return 8
    }

    class BaseViewHolder(private val binding: RecyclerItemCarInfoBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int, labels: Array<String>) {
            binding.tilCarInfoRecycler.hint = labels[position]

            binding.tietCarInfoRecycler.addTextChangedListener(TFValidationCar(labels[position]))
        }

        inner class TFValidationCar(private val type: String): TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                when(type) {
                    "Гос номер" -> {
                        validateStateNumber()
                    }
                    "Марка" -> {
                        validateBrand()
                    }
                    "Модель" -> {
                        validateModel()
                    }
                    "Цвет машины" -> {
                        vflidateColor()
                    }
                    "Номер модели" -> {
                        validateModelNumber()
                    }
                    "Номер двигателя" -> {
                        validateEnjineNumber()
                    }
                    "Тип двигателя" -> {

                    }
                    "Тип трансмиссии" -> {
                    }
                }
            }

        }
        private fun validateStateNumber(): Boolean {
            if (!isValidateStateNumber(binding.tietCarInfoRecycler.text.toString())) {
                binding.tilCarInfoRecycler.error = "Номер не соответствует формату"
                binding.tietCarInfoRecycler.requestFocus()
                return false
            } else {
                binding.tilCarInfoRecycler.isErrorEnabled = false
            }

            return true
        }

        private fun isValidateStateNumber(s: String): Boolean {
            val text = s.toUpperCase(Locale.ROOT)
            val pattern = Pattern.compile("^[А, В, Е, К, М, Н, О, Р, С, Т, У, Х]([0-9]){3}([А, В, Е, К, М, Н, О, Р, С, Т, У, Х]){2}([0-9]){2,3}")
            val matcher =pattern.matcher(text)
            return matcher.matches()
        }

        private fun validateEnjineNumber() {
            TODO("Not yet implemented")
        }

        private fun validateModelNumber() {
            TODO("Not yet implemented")
        }

        private fun vflidateColor() {
            TODO("Not yet implemented")
        }

        private fun validateModel() {
            TODO("Not yet implemented")
        }

        private fun validateBrand() {

        }
    }

    class TransmissionHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rbtnLeft = itemView.findViewById<RadioButton>(R.id.rb_left)
        val rbtnRight = itemView.findViewById<RadioButton>(R.id.rb_right)

        fun bind(position: Int) {
            when(position) {
                6 -> {
                    rbtnLeft.text = "Бензин"
                    rbtnRight.text = "Дизель"
                }

                7 -> {
                    rbtnLeft.text = "Автоматическая"
                    rbtnRight.text = "Механическая"
                }
            }
        }
    }
}
