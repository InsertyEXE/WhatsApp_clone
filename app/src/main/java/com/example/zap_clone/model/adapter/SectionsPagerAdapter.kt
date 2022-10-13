package com.example.zap_clone.model.adapter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.zap_clone.R
import com.example.zap_clone.model.User
import com.example.zap_clone.view.main.conversation.ConversationFragment
import com.example.zap_clone.view.main.StatusFragment
import com.example.zap_clone.view.main.StatusFragment.Companion.KEY_USER_STATS

/*

        ADAPTER DA TABLAYOUT

 */

private val TAB_TITLES = arrayOf(
    R.string.conversar,
    R.string.status
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager, data: User) :
    FragmentPagerAdapter(fm) {

    private val userInfo = data

    override fun getItem(position: Int): Fragment {

        val conversation: ConversationFragment = ConversationFragment()
        val stats: StatusFragment = StatusFragment()
        val args = Bundle()


       return when (position) {
            0 -> {
                conversation
            }
           else -> {
               args.putParcelable(KEY_USER_STATS, userInfo)
               stats.arguments = args
               stats
           }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }
}