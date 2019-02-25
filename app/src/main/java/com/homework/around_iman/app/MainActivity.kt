package com.homework.around_iman.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.homework.around_iman.R
import com.homework.around_iman.data.PlaceRepository
import com.homework.around_iman.data.model.PlaceEntity
import com.homework.around_iman.remote.NetworkManager
import com.homework.around_iman.remote.datasource.PlaceDataSource
import com.homework.around_iman.remote.service.PlaceService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val placeRepository = PlaceRepository(PlaceDataSource(PlaceService(NetworkManager())))
        placeRepository.getFeaturedPlaces(::onFeaturedPlace)
    }
    private fun onFeaturedPlace(list: List<PlaceEntity>?) = runOnUiThread {
        Toast.makeText(this,list.toString(),Toast.LENGTH_LONG).show()
    }
}

