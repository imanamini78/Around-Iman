package com.homework.around_iman.remote.datasource

import com.homework.around_iman.remote.model.response.PlaceDto
import com.homework.around_iman.remote.service.PlaceService

class PlaceDataSource(private val placeService: PlaceService){

    fun getFeaturedPlaces() : List<PlaceDto>? {
        return placeService.getFeaturedPlaceResponse()
            .response?.items
    }
}