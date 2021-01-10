package com.varenie.carservice.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.varenie.carservice.R

//адаптер для спикска машин в профиле
class UserCarsAccAdapter: RecyclerView.Adapter<UserCarsAccAdapter.MyHolder>() {

    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val brend = itemView.findViewById<TextView>(R.id.tv_acc_car_brand)
        val statenumber = itemView.findViewById<TextView>(R.id.tv_acc_car_number)
        val isService = itemView.findViewById<TextView>(R.id.tv_is_in_service)

        init {
            super.itemView

//          пока простой переход в фрагмент, потом так же будут передаваться параметры
            itemView.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_acc_to_carInfo)
            }
        }
        fun bind() {
//            Тут будет размещаться инфа на элементах
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.acc_cars_recycler_item, parent, false)

        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind()
    }

    //временное решение, для проверки работоспособности
    override fun getItemCount(): Int {
        return 2
    }

}