package com.myself223.main.presentation.ui.adapters.view_pager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.myself223.main.presentation.ui.fragments.characters.CharactersFragment
import com.myself223.main.presentation.ui.fragments.episodes.EpisodesFragment
import com.myself223.main.presentation.ui.fragments.locations.LocationFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val fragments = listOf(
        CharactersFragment(),
        EpisodesFragment(),
        LocationFragment(),
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}
