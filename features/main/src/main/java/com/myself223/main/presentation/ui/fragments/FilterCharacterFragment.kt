package com.myself223.main.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.myself223.main.R
import com.myself223.main.databinding.FragmentFilterBinding
import com.myself223.main.presentation.ui.fragments.characters.CharacterViewModel

class FilterCharacterFragment : BottomSheetDialogFragment() {

    private val binding by lazy { FragmentFilterBinding.inflate(layoutInflater) }
    private val characterViewModel: CharacterViewModel by viewModels({ requireParentFragment() })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnApplyFilters.setOnClickListener {
            val status = when (binding.radioGroupStatus.checkedRadioButtonId) {
                R.id.radioStatusAlive -> "Alive"
                R.id.radioStatusDead -> "Dead"
                R.id.radioStatusUnknown -> "unknown"
                else -> null
            }

            val species = when (binding.radioGroupSpecies.checkedRadioButtonId) {
                R.id.radioSpeciesHuman -> "Human"
                R.id.radioSpeciesHumanoid -> "Humanoid"
                R.id.radioSpeciesAlien -> "Alien"
                else -> null
            }

            val gender = when (binding.radioGroupGender.checkedRadioButtonId) {
                R.id.radioGenderMale -> "Male"
                R.id.radioGenderFemale -> "Female"
                R.id.radioGenderUnknown -> "unknown"
                else -> null
            }

            characterViewModel.applyFilters(status, species, gender)
            dismiss()
        }
        binding.btnUnApply.setOnClickListener {
            characterViewModel.resetFilters()
            dismiss()
        }
    }


}
