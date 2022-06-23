package com.example.weathertask.ui.weather.future

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.weathertask.R
import com.example.weathertask.databinding.FragmentFutureWeatherBinding
import com.example.weathertask.utils.viewBinding
import org.koin.android.ext.android.get

class FutureWeatherFragment : Fragment(R.layout.fragment_future_weather) {

    private val viewModel = get<FutureWeatherViewModel>()
    private val binding by viewBinding (FragmentFutureWeatherBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewModel.init()
    }

    private fun initView(){
        viewModel.downloadedForecastWeather.observe(viewLifecycleOwner) { response ->
            response?.let {
                binding.futureWeather.text = it.list.toString()
                Log.v("", "Forecast weather: ${it.list.toString()}")
            }
        }
    }
}