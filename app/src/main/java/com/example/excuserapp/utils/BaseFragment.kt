package com.example.excuserapp.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.excuserapp.adapter.ExcuseAdapter
import com.example.excuserapp.databinding.FragmentSingleExcuseBinding
import com.example.excuserapp.viewmodel.ExcuseViewModel

open class BaseFragment : Fragment() {

    protected val binding by lazy {
        FragmentSingleExcuseBinding.inflate(layoutInflater)
    }

    protected val excuseAdapter by lazy {
        ExcuseAdapter()
    }

    protected val excuseViewModel by lazy {
        ViewModelProvider(requireActivity())[ExcuseViewModel::class.java]
    }
}