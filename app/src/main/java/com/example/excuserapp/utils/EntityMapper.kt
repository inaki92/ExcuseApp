package com.example.excuserapp.utils

import com.example.excuserapp.model.Excuse
import com.example.excuserapp.model.ExcuseNetworkEntity

interface EntityMapper<Entity, DomainModel> {
    fun mapFromEntity(entity: Entity): DomainModel
    fun mapToEntity(domainModel: DomainModel): Entity
}

class NetworkMapper : EntityMapper<ExcuseNetworkEntity, Excuse> {

    override fun mapFromEntity(entity: ExcuseNetworkEntity): Excuse =
        Excuse(
            category = ExcuseCategory.valueOf(entity.category),
            excuse = entity.excuse,
            id = entity.id
        )

    override fun mapToEntity(domainModel: Excuse): ExcuseNetworkEntity =
        ExcuseNetworkEntity(
            category = domainModel.category.name.lowercase(),
            excuse = domainModel.excuse,
            id = domainModel.id
        )

    fun mapFromEntityList(entities: List<ExcuseNetworkEntity>): List<Excuse> =
        entities.map { mapFromEntity(it) }
}