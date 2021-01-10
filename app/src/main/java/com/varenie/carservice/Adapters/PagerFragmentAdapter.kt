package com.varenie.carservice.Adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.varenie.carservice.Fragments.PagerFragment

class PagerFragmentAdapter(fm: FragmentManager, context: Context, private val size: Int): FragmentPagerAdapter(fm) {
    private val titles = arrayOf("Замена масла", "ТО", "Замена деталей")

    override fun getCount(): Int {
        return size
    }

    override fun getItem(position: Int): Fragment {
//      всек еще есть баг с неправильным отображением фрагментов, они иногда пропадают

        return PagerFragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}