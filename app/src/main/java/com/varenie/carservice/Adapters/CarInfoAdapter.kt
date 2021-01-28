package com.varenie.carservice.Adapters

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.varenie.carservice.R
import com.varenie.carservice.databinding.RecyclerItemCarInfoBinding
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
        if (position == 7) {
            return 0
        }
        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        if (viewType == 0) {
            val view = inflater.inflate(R.layout.recycler_item_transmission, null)
            binding = DataBindingUtil.inflate(inflater, R.layout.recycler_item_transmission, parent, false)
            return TransmissionHolder(view)
        }

        val view = inflater.inflate(R.layout.recycler_item_car_info, null)
        binding = DataBindingUtil.inflate(inflater, R.layout.recycler_item_car_info, parent, false)
        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TransmissionHolder -> holder.bind()
            is BaseViewHolder -> holder.bind(position, labels)
        }
    }

    override fun getItemCount(): Int {
        return 8
    }

    class BaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tilFiewld = itemView.findViewById<TextInputLayout>(R.id.til_car_info_recycler)
        val tietFiewld = itemView.findViewById<TextInputEditText>(R.id.tiet_car_info_recycler)

        fun bind(position: Int, labels: Array<String>) {
            tilFiewld.hint = labels[position]

            tietFiewld.addTextChangedListener(TFValidationCar(labels[position]))
        }
    }

    class TransmissionHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind() {

        }
    }

    class TFValidationCar(private val type: String): TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {
            when(type) {
                "Гос номер" -> {
                    validateStateNumber(s.toString())
                }
                "Марка" -> {

                }
                "Модель" -> {
                }
                "Цвет машины" -> {
                }
                "Номер модели" -> {
                }
                "Номер двигателя" -> {
                }
                "Тип двигателя" -> {
                }
                "Тип трансмиссии" -> {
                }
            }
        }

        private fun validateStateNumber(text: String) {
            if (!isValidateStateNumber(text)) {
                Log.e("STATENUMBER", "wrong")
            } else {
                Log.e("STATENUMBER", "yeah boy")
            }
        }

        fun isValidateStateNumber(text: String): Boolean {
            val pattern = Pattern.compile("^[А, В, Е, К, М, Н, О, Р, С, Т, У, Х]([0-9]){3}([А, В, Е, К, М, Н, О, Р, С, Т, У, Х]){2}([0-9]){2,3}")
            val matcher =pattern.matcher(text)
            return matcher.matches()
        }
    }
}
