package com.homework.around_iman.data

import com.homework.around_iman.data.model.PlaceEntity
import com.homework.around_iman.remote.datasource.PlaceDataSource

class PlaceRepository(private val placeDataSource: PlaceDataSource){
    fun getFeaturedPlaces (success : (List<PlaceEntity>?) -> Unit) {
        Thread{
            val result  = placeDataSource.getFeaturedPlaces()?.map {
                PlaceEntity(it.full_name)
            }

            success(result)
        }.start()
    }
}