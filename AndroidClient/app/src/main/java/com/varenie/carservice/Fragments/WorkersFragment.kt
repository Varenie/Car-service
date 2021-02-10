package com.varenie.carservice.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.varenie.carservice.Adapters.AllServicesAdapter
import com.varenie.carservice.Adapters.WorkersAdapter
import com.varenie.carservice.R

class WorkersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root =  inflater.inflate(R.layout.fragment_workers, container, false)

        val myRecycler = root.findViewById<RecyclerView>(R.id.rv_workers)

        myRecycler.layoutManager = LinearLayoutManager(requireContext())
        myRecycler.setHasFixedSize(true)

        val adapter = WorkersAdapter()
        myRecycler.adapter = adapter

        return root
    }


}