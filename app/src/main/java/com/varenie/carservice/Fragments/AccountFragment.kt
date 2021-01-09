package com.varenie.carservice.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.varenie.carservice.Adapters.FavoriteServicesAdapter
import com.varenie.carservice.Adapters.UserCarsAccAdapter
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
        val carAdapter = UserCarsAccAdapter()
        val servicesAdapter = FavoriteServicesAdapter()

//      переход на редактирование профиля
        val btnEdit = root.findViewById<ImageButton>(R.id.ibtn_change_info)
        btnEdit.setOnClickListener {
//        Вызввается действие перехода из фрагмента аккаунта, в фрагмент тзменения инфы
            Navigation.findNavController(it).navigate(R.id.action_acc_to_edit_user)
        }

//      переход на добавление машины (изменение инфы о машине реализовано в адаптере списка)
        val btnAddCar = root.findViewById<ImageButton>(R.id.ibtn_add_car)
        btnAddCar.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_acc_to_carInfo)
        }

        carRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false) // для горизонтального списка
        carRecycler.setHasFixedSize(true)
        servicesRecycler.layoutManager = LinearLayoutManager(requireContext())
        servicesRecycler.setHasFixedSize(true)

        carRecycler.adapter = carAdapter
        servicesRecycler.adapter = servicesAdapter

        return root
    }
}