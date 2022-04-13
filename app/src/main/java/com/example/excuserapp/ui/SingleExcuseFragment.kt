package com.example.excuserapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.excuserapp.R
import com.example.excuserapp.databinding.FragmentSingleExcuseBinding
import com.example.excuserapp.utils.BaseFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SingleExcuseFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.excuseRecycler.isVisible = false
        binding.loadingExcuse.isVisible = false
        binding.btnLayout.isVisible = true

        binding.famExcuseBtn.setOnClickListener {
            findNavController().navigate(R.id.action_SingleRandomExcuse_to_FamilyExcuse)
        }

        binding.officeExcuseBtn.setOnClickListener {
            findNavController().navigate(R.id.action_SingleRandomExcuse_to_OfficeExcuse)
        }

        binding.collegeExcuseBtn.setOnClickListener {
            findNavController().navigate(R.id.action_SingleRandomExcuse_to_CollegeExcuse)
        }

        binding.childrenExcuseBtn.setOnClickListener {
            findNavController().navigate(R.id.action_SingleRandomExcuse_to_ChildrenExcuse)
        }

        binding.partyExcuseBtn.setOnClickListener {
            findNavController().navigate(R.id.action_SingleRandomExcuse_to_PartyExcuse)
        }

        return binding.root
    }
}