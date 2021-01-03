package com.varenie.carservice.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.varenie.carservice.Adapters.FavoriteServicesAdapter
import com.varenie.carservice.Adapters.UserClassAccAdapter
import com.varenie.carservice.R

class AccountFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_account, container, false)

        val carRecycler = root.findViewById<RecyclerView>(R.id.rv_acc_cars_recycler)
        val servicesRecycler = root.findViewById<RecyclerView>(R.id.rv_favorite_services)
        val carAdapter = UserClassAccAdapter()
        val servicesAdapter = FavoriteServicesAdapter()

        carRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false) // для горизонтального списка
        carRecycler.setHasFixedSize(true)
        servicesRecycler.layoutManager = LinearLayoutManager(requireContext())
        servicesRecycler.setHasFixedSize(true)

        carRecycler.adapter = carAdapter
        servicesRecycler.adapter = servicesAdapter

        return root
    }
}