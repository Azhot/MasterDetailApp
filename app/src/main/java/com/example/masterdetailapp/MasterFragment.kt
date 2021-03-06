package com.example.masterdetailapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.masterdetailapp.databinding.FragmentMasterBinding

class MasterFragment : Fragment(), View.OnClickListener {

    // variables
    // using View Binding
    private lateinit var binding: FragmentMasterBinding
    private lateinit var navController: NavController


    // overridden functions
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMasterBinding.inflate(layoutInflater)
        setUpButtonClickListener(binding.masterButton)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(
            requireActivity(),
            R.id.main_fragment_container
        )
    }

    override fun onResume() {
        super.onResume()
        // true only in landscape
        if (binding.detailFragmentContainer != null) {
            childFragmentManager.beginTransaction()
                .replace(binding.detailFragmentContainer!!.id, DetailFragment())
                .commit()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            // navigating to detail fragment
            binding.masterButton?.id -> {
                navController.navigate(MasterFragmentDirections.actionMasterFragmentToDetailFragment())
            }
        }
    }


    // functions
    private fun setUpButtonClickListener(button: Button?) {
        button?.setOnClickListener(this)
    }
}
