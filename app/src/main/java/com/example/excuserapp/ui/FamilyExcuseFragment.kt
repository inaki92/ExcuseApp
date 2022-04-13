package com.example.excuserapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.excuserapp.model.Excuse
import com.example.excuserapp.utils.BaseFragment
import com.example.excuserapp.utils.ExcuseCategory
import com.example.excuserapp.utils.ResultState
import com.example.excuserapp.utils.ViewIntentRequest

class FamilyExcuseFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.btnLayout.isVisible = false

        binding.excuseRecycler.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = excuseAdapter
        }

        excuseViewModel.excuses.observe(viewLifecycleOwner) {
            when(it) {
                is ResultState.LOADING -> {
                    binding.btnLayout.isVisible = false
                    binding.loadingExcuse.isVisible = true
                    binding.excuseRecycler.isVisible = false
                }
                is ResultState.SUCCESS<*> -> {
                    val excuseList = it.response as List<Excuse>
                    binding.btnLayout.isVisible = false
                    binding.loadingExcuse.isVisible = false
                    binding.excuseRecycler.isVisible = true
                    excuseAdapter.updateData(excuseList)
                }
                is ResultState.ERROR -> {

                }
            }
        }

        excuseViewModel.getViewIntent(ViewIntentRequest.FamilyExcuse(ExcuseCategory.FAMILY))

        return binding.root
    }
}