package com.homework.around_iman.remote.service

import com.homework.around_iman.remote.model.response.FeaturePlacesResponseDto
import com.google.gson.Gson
import com.homework.around_iman.remote.NetworkManager

class PlaceService(private val networkManager: NetworkManager){


    fun getFeaturedPlaceResponse (): FeaturePlacesResponseDto{
        val rawData = networkManager.get(URL_FEATURED)
        return Gson().fromJson(rawData,FeaturePlacesResponseDto::class.java)
    }


    companion object {
        const val URL_FEATURED = "https://restapis.xyz/around-me/v1/featured"
    }
}

