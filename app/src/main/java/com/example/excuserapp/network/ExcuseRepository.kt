package com.example.excuserapp.network

import com.example.excuserapp.model.Excuse
import com.example.excuserapp.utils.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface ExcuseRepository {
    fun getRandomExcuseByCategory(category: ExcuseCategory): Flow<Excuse>
    fun getRandomExcuse(): Flow<Excuse>
    fun getRandomExcuseAsList(limit: Int = 50): Flow<List<Excuse>>
    fun getExcuseAsListByCategory(category: ExcuseCategory, limit: Int = 20): Flow<ResultState>
}

class ExcuseRepositoryImpl(
    private val networkMapper: NetworkMapper = NetworkMapper(),
    private val excuseService: ExcuseService = Service.excuseService
) : ExcuseRepository {

    override fun getRandomExcuseByCategory(category: ExcuseCategory): Flow<Excuse> = flow {
        try {
            val response = excuseService.getRandomExcuse(category = category.name.lowercase())
            if(response.isSuccessful) {
                response.body()?.let {
                    val entityMap = networkMapper.mapFromEntity(it)
                    emit(entityMap)
                } ?: throw NullResponseException()
            } else {
                throw ResponseIsFailingException()
            }
        } catch (e: Exception) {

        }
    }

    override fun getRandomExcuse(): Flow<Excuse> = flow {
        try {
            val response = excuseService.getRandomExcuse()
            if(response.isSuccessful) {
                response.body()?.let {
                    val entityMap = networkMapper.mapFromEntity(it)
                    emit(entityMap)
                } ?: throw NullResponseException()
            } else {
                throw ResponseIsFailingException()
            }
        } catch (e: Exception) {

        }
    }

    override fun getRandomExcuseAsList(limit: Int): Flow<List<Excuse>> = flow {
        try {
            val response =
                excuseService.getListOfExcuses(limit = limit)
            if (response.isSuccessful) {
                response.body()?.let {
                    val entityMap = networkMapper.mapFromEntityList(it)
                    emit(entityMap)
                } ?: throw NullResponseException()
            } else {
                throw ResponseIsFailingException()
            }
        } catch (e: Exception) {

        }
    }

    override fun getExcuseAsListByCategory(category: ExcuseCategory, limit: Int): Flow<ResultState> = flow {
        emit(ResultState.LOADING)

        delay(1000)

        try {
            val response =
                excuseService.getListOfExcuses(category = category.name.lowercase(), limit = limit)
            if (response.isSuccessful) {
                response.body()?.let {
                    val entityMap = networkMapper.mapFromEntityList(it)
                    emit(ResultState.SUCCESS(entityMap))
                } ?: throw NullResponseException()
            } else {
                throw ResponseIsFailingException()
            }
        } catch (e: Exception) {
            emit(ResultState.ERROR(e))
        }
    }
}