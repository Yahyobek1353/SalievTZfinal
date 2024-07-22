package com.myself223.main.presentation.ui.fragments.characters

import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.myself223.core.base.BaseFragment
import com.myself223.main.R
import com.myself223.main.databinding.FragmentCharactersBinding
import com.myself223.main.presentation.ui.adapters.character.CharacterAdapter
import com.myself223.main.presentation.ui.fragments.FilterCharacterFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment<FragmentCharactersBinding, CharacterViewModel>(R.layout.fragment_characters) {
    override val viewModel: CharacterViewModel by viewModel()
    private val characterAdapter: CharacterAdapter by lazy { CharacterAdapter() }
    override val binding: FragmentCharactersBinding by viewBinding(FragmentCharactersBinding::bind)

    override fun init() {
        binding.rvCharacters.adapter = characterAdapter
    }

    override fun constructorListeners() {
        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.searchCharacters(it)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    viewModel.searchCharacters(it)
                }
                return true
            }
        })

        binding.btnSearch.setOnClickListener {
            FilterCharacterFragment().show(childFragmentManager, "FilterFragment")
        }
    }

    override fun launchObserver() {
        viewModel.getCharacter().observeUIPaging {character->
            characterAdapter.submitData(character)
        }
        lifecycleScope.launch {
            viewModel.characterResults.collectLatest {
                characterAdapter.submitData(it)
            }
        }
    }
}
