package com.varenie.carservice.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
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

        val btnEdit = root.findViewById<Button>(R.id.btn_change_info)
        btnEdit.setOnClickListener{
            editProfile(it)
        }

        carRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false) // для горизонтального списка
        carRecycler.setHasFixedSize(true)
        servicesRecycler.layoutManager = LinearLayoutManager(requireContext())
        servicesRecycler.setHasFixedSize(true)

        carRecycler.adapter = carAdapter
        servicesRecycler.adapter = servicesAdapter

        return root
    }

    fun editProfile(view: View) {
//        Вызввается действие перехода из фрагмента аккаунта, в фрагмент тзменения инфы
        Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_userInfoFragment)
    }
}