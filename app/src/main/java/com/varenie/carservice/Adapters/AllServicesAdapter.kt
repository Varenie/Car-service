package com.varenie.carservice.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.varenie.carservice.R

class AllServicesAdapter: RecyclerView.Adapter<AllServicesAdapter.MyHolder>() {
    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tv_service_name)
        val description = itemView.findViewById<TextView>(R.id.tv_service_description)
        val price = itemView.findViewById<TextView>(R.id.tv_service_price)

        fun bind() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.all_services_recycler_item, null)

        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind()
    }

//  временно
    override fun getItemCount(): Int {
        return 3
    }


}