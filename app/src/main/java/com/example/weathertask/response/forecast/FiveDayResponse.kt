package com.example.weathertask.response.forecast

import com.example.weathertask.response.Weather
import com.google.gson.annotations.SerializedName


class FiveDayResponse {
    @SerializedName("city")
    var city: City? = null

    @SerializedName("cnt")
    var cnt = 0

    @SerializedName("cod")
    var cod: String? = null

    @SerializedName("message")
    var message = 0.0

    @SerializedName("list")
    var list: List<Weather>? = null
}