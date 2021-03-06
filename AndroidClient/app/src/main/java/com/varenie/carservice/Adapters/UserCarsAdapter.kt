package com.varenie.carservice.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.varenie.carservice.R

class UserCarsAdapter: RecyclerView.Adapter<UserCarsAdapter.MyHolder>() {

    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val brand = itemView.findViewById<TextView>(R.id.tv_car_brand)
        val model = itemView.findViewById<TextView>(R.id.tv_car_model)
        val color = itemView.findViewById<TextView>(R.id.tv_car_color)
        val stateNumber = itemView.findViewById<TextView>(R.id.tv_car_state_number)
        val modelNumber = itemView.findViewById<TextView>(R.id.tv_model_number)
        val engineNumber = itemView.findViewById<TextView>(R.id.tv_engine_number)
        val engineType = itemView.findViewById<TextView>(R.id.tv_engine_type)
        val transmission = itemView.findViewById<TextView>(R.id.tv_transmission)

        init {
            super.itemView

            itemView.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_cars_to_History)
            }

        }

        fun bind() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.recycler_item_user_cars, parent, false)

        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind()
    }

//    Временное решение
    override fun getItemCount(): Int {
        return 3
    }
}