package com.myself223.main.presentation.ui.fragments.locations

import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.myself223.core.base.BaseFragment
import com.myself223.main.R
import com.myself223.main.databinding.FragmentLocationBinding
import com.myself223.main.presentation.ui.adapters.location.LocationAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<FragmentLocationBinding, LocationViewModel>(R.layout.fragment_location) {
    private val locationAdapter: LocationAdapter by lazy { LocationAdapter() }
    override val binding:FragmentLocationBinding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModel()


    override fun init() {
        binding.rvLocation.adapter = locationAdapter
    }

    override fun constructorListeners() {
        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.searchLocation(it)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    viewModel.searchLocation(it)
                }
                return true
            }
        })
    }


    override fun launchObserver() {
        viewModel.getLocation().observeUIPaging {character->
            locationAdapter.submitData(character)
        }
        lifecycleScope.launch {
            viewModel.locationResults.collectLatest {
                locationAdapter.submitData(it)
            }
        }
    }




}