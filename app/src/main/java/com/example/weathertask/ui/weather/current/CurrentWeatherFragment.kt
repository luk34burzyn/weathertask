package com.example.weathertask.ui.weather.current

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.weathertask.R
import com.example.weathertask.databinding.FragmentCurrentWeatherBinding
import com.example.weathertask.utils.viewBinding
import org.koin.android.ext.android.get

class CurrentWeatherFragment : Fragment(R.layout.fragment_current_weather) {

    private val binding by viewBinding(FragmentCurrentWeatherBinding::bind)
    private val viewModel = get<CurrentWeatherViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewModel.init()
    }

    private fun initView(){
        viewModel.downloadedCurrentWeather.observe(viewLifecycleOwner) { response ->
            response?.let {
                binding.currentWeather.text = it.toString()
                Log.v("", "Current weather: $it")
            }
        }

    }

}
