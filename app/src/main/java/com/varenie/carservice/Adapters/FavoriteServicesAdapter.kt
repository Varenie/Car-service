package com.varenie.carservice.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.varenie.carservice.R

class FavoriteServicesAdapter: RecyclerView.Adapter<FavoriteServicesAdapter.MyHolder>() {
    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tv_acc_service_name)
        val price = itemView.findViewById<TextView>(R.id.tv_acc_service_price)

        fun bind() {
//            Тут будет размещаться инфа на элементах
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.acc_favorite_services_recycler_item, parent, false)

        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind()
    }

//    временное решение
    override fun getItemCount(): Int {
        return 5
    }
}