package com.myself223.main.presentation.ui.fragments.episodes

import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.myself223.core.base.BaseFragment
import com.myself223.main.R
import com.myself223.main.databinding.FragmentEpisodesBinding
import com.myself223.main.presentation.ui.adapters.episodes.EpisodesAdapter
import com.myself223.main.presentation.ui.fragments.characters.CharacterViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodesFragment : BaseFragment<FragmentEpisodesBinding, EpisodesViewModel>(R.layout.fragment_episodes) {
    private val episodesAdapter: EpisodesAdapter by lazy { EpisodesAdapter() }
    override val binding:FragmentEpisodesBinding by viewBinding(FragmentEpisodesBinding::bind)
    override val viewModel: EpisodesViewModel by viewModel()


    override fun init() {
        binding.rvEpisodes.adapter = episodesAdapter
    }

    override fun constructorListeners() {
        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.searchEpisodes(it)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    viewModel.searchEpisodes(it)
                }
                return true
            }
        })
    }


    override fun launchObserver() {
        viewModel.getEpisodes().observeUIPaging {character->
            episodesAdapter.submitData(character)
        }
        lifecycleScope.launch {
            viewModel.episodesResults.collectLatest {
                episodesAdapter.submitData(it)
            }
        }
    }





}