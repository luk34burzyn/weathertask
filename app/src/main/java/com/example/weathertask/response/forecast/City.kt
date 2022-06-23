package com.example.weathertask.response.forecast

import com.example.weathertask.response.Coord
import com.google.gson.annotations.SerializedName


class City (
    @SerializedName("country")
    var country: String? = null,
    @SerializedName("coord")
    var coord: Coord? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("id")
    var id :Long = 0,
    @SerializedName("population")
    var population: Long = 0
)