package com.example.weathertask.data

import android.util.Log
import com.example.weathertask.data.network.ConnectivityInterceptor
import com.example.weathertask.response.CurrentWeatherResponse
import com.example.weathertask.response.forecast.FiveDayResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val URL = "https://api.openweathermap.org/data/2.5/"

interface ApixuWeatherApiService {

    /**
     * Get current weather of city
     *
     * @param q     String name of city
     * @param units String units of response
     * @param lang  String language of response
     * @param appId String api key
     * @return instance of {@link CurrentWeatherResponse}
     */
    @GET("weather")
    fun getCurrentWeatherAsync(
        @Query("q") q: String?,
        @Query("units") units: String?,
        @Query("lang") lang: String?,
        @Query("appid") appId: String?
    ): Deferred<CurrentWeatherResponse>

    /**
     * Get five days weather forecast.
     *
     * @param q     String name of city
     * @param units String units of response
     * @param lang  String language of response
     * @param appId String api key
     * @return instance of FiveDayResponse
     */

    @GET("forecast")
    fun getFiveDaysWeatherAsync(
        @Query("q") q: String?,
        @Query("units") units: String?,
        @Query("lang") lang: String?,
        @Query("appid") appId: String?
    ): Deferred<FiveDayResponse>


    companion object {
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ): ApixuWeatherApiService {

            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                    .url
                    .newBuilder()
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient
                .Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit.Builder()
                .baseUrl(URL)
                .client(okHttpClient)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApixuWeatherApiService::class.java)
        }


        const val TAG = "ApixuWeather"
    }

    class gfgInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val aRequest: Request = chain.request()
            val aResponse = chain.proceed(aRequest)
            when (aResponse.code) {
                400 -> {
                    // Show Bad Request Error Message
                    Log.d(TAG, "Bad Request Error Message")
                }
                401 -> {
                    // Show UnauthorizedError Message
                    Log.d(TAG, "UnauthorizedError Message")
                }

                403 -> {
                    // Show Forbidden Message
                    Log.d(TAG, "Forbidden Message")
                }

                404 -> {
                    // Show NotFound Message
                    Log.d(TAG, "NotFound Message")
                }
            }
            return aResponse
        }
    }
}
