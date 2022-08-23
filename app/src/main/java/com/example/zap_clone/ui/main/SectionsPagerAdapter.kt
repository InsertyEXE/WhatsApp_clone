package com.example.zap_clone.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.zap_clone.R

private val TAB_TITLES = arrayOf(
    R.string.conversar,
    R.string.status
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {

        val conversation: ConversasFragment = ConversasFragment()
        val stats: StatusFragment = StatusFragment()

       return when (position) {
            0 -> conversation
           else -> stats
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }
}