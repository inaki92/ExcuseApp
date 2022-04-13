package com.example.excuserapp.utils

sealed class ResultState {
    object LOADING : ResultState()
    class SUCCESS<T>(val response: T) : ResultState()
    class ERROR(val error: Throwable): ResultState()
}

sealed class ViewIntentRequest {
    class ChildrenExcuse(val category: ExcuseCategory) : ViewIntentRequest()
    class FamilyExcuse(val category: ExcuseCategory) : ViewIntentRequest()
    class OfficeExcuse(val category: ExcuseCategory) : ViewIntentRequest()
    class PartyExcuse(val category: ExcuseCategory) : ViewIntentRequest()
    class CollegeExcuse(val category: ExcuseCategory) : ViewIntentRequest()
}
