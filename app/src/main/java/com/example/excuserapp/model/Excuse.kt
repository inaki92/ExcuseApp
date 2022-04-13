package com.example.excuserapp.model

import com.example.excuserapp.utils.ExcuseCategory

data class Excuse(
    var category: ExcuseCategory,
    var excuse: String,
    var id: Int
)
