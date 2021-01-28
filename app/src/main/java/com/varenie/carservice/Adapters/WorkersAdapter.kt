package com.varenie.carservice.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.varenie.carservice.R

class WorkersAdapter: RecyclerView.Adapter<WorkersAdapter.MyHolder>() {
    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val fio = itemView.findViewById<TextView>(R.id.tv_worker_FIO)
        val description = itemView.findViewById<TextView>(R.id.tv_worker_description)
        val services = itemView.findViewById<TextView>(R.id.tv_worker_services)

        fun bind() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.recycler_item_workers, null)

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