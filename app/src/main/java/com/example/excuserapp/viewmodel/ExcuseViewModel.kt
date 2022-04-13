package com.example.excuserapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.excuserapp.network.ExcuseRepository
import com.example.excuserapp.network.ExcuseRepositoryImpl
import com.example.excuserapp.utils.ExcuseCategory
import com.example.excuserapp.utils.ResultState
import com.example.excuserapp.utils.ViewIntentRequest
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExcuseViewModel(
    private val repository: ExcuseRepository = ExcuseRepositoryImpl(),
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {


    private val _excuses: MutableLiveData<ResultState> = MutableLiveData()
    val excuses: LiveData<ResultState> get() = _excuses


    fun getViewIntent(viewIntentRequest: ViewIntentRequest) {

        when(viewIntentRequest) {
            is ViewIntentRequest.CollegeExcuse -> {

            }
            is ViewIntentRequest.OfficeExcuse -> {

            }
            is ViewIntentRequest.FamilyExcuse -> {
                handleFamily(viewIntentRequest.category)
            }
            is ViewIntentRequest.ChildrenExcuse -> {

            }
            is ViewIntentRequest.PartyExcuse -> {

            }
        }
    }

    private fun handleFamily(category: ExcuseCategory) {
        viewModelScope.launch(ioDispatcher) {
            repository.getExcuseAsListByCategory(category).collect {
                _excuses.postValue(it)
            }
        }
    }
}

