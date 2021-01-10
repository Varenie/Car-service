package com.varenie.carservice.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.varenie.carservice.Adapters.PagerFragmentAdapter
import com.varenie.carservice.R

// в данном фрагменте будет находится пэйджер, со разными историями ремонта и тд
class ServicesHistoryFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_services_history, container, false)

        val viewPager = root.findViewById<ViewPager>(R.id.vp_history)

//      проверка на null fragmentManger
        val myAdapter = fragmentManager?.let {
            PagerFragmentAdapter(it, requireContext(), 3)
        }
        viewPager.adapter = myAdapter

        return root
    }


}