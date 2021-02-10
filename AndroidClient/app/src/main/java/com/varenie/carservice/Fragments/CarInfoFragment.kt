package com.varenie.carservice.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.varenie.carservice.Adapters.CarInfoAdapter
import com.varenie.carservice.R
import com.varenie.carservice.databinding.FragmentCarInfoBinding

class CarInfoFragment : Fragment() {

    lateinit var binding: FragmentCarInfoBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_car_info, container, false)

        binding.rvCarInfo.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCarInfo.setHasFixedSize(true)

        val adapter = CarInfoAdapter()
        binding.rvCarInfo.adapter = adapter

        return binding.root
    }

}