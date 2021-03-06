package com.example.masterdetailapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.masterdetailapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    // variables
    // using View Binding
    private lateinit var binding: FragmentDetailBinding
    private lateinit var navController: NavController


    // overridden functions
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(
            requireActivity(),
            R.id.main_fragment_container
        )
    }

    override fun onResume() {
        super.onResume()
        // see bools.xml resource file
        // used to easily find device's orientation
        if (activity?.resources?.getBoolean(R.bool.isLandscape) == true) {
            navController.navigateUp()
        }
    }
}
