package com.example.excuserapp.network

import com.example.excuserapp.model.ExcuseNetworkEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ExcuseService {

   @GET(CATEGORY_PATH)
   suspend fun getRandomExcuse(
       @Path("category") category: String? = null
   ): Response<ExcuseNetworkEntity>

    @GET(CATEGORY_PATH_LIST)
    suspend fun getListOfExcuses(
        @Path("category") category: String? = null,
        @Path("limit") limit: Int
    ): Response<List<ExcuseNetworkEntity>>

   companion object {
       const val BASE_URL = "https://excuser.herokuapp.com/v1/excuse/"
       private const val CATEGORY_PATH = "{category}"
       private const val CATEGORY_PATH_LIST = "{category}/{limit}"
   }
}