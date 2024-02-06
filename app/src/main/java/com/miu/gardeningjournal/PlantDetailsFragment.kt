package com.miu.gardeningjournal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.miu.gardeningjournal.databinding.FragmentPlantDetailsBinding

class PlantDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPlantDetailsBinding
    private val nargs: PlantDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlantDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View, savedInstanceState:
        Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve and set the Arguments received from the Garden Log Fragment
        binding.textViewPlantName.text = nargs.pname
        binding.textViewPlantType.text = nargs.ptype
        binding.textViewWateringFrequency.text = nargs.waterFrequency
        binding.textViewPlantingDate.text = nargs.pdate
    }
}