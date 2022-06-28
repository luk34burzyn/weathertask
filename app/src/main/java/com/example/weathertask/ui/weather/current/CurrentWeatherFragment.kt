package com.example.weathertask.ui.weather.current

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.weathertask.R
import com.example.weathertask.databinding.FragmentCurrentWeatherBinding
import com.example.weathertask.utils.viewBinding
import org.koin.android.ext.android.get
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

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
                binding.updatedAt.text  =
                    SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(
                        Date(
                            it.dt.toLong().times(1000)
                        )
                    )
                binding.skies.text = it.weather?.get(0)?.description?.uppercase()
                binding.temp.text = it.main?.temp?.roundToInt().toString() + "°C"
                binding.tempMin.text = "Min temp.: " + it.main?.temp_min?.roundToInt().toString() + "°C"
                binding.tempMax.text = "Max temp.: " + it.main?.temp_max?.roundToInt().toString() + "°C"
                binding.humidity.text = it.main?.humidity.toString()
                binding.pressure.text = it.main?.pressure.toString()
                binding.sunrise.text =
                    SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(
                        Date(
                            it.sys?.sunrise?.toLong()?.times(1000) ?: 0L
                        )
                    )
                binding.sunset.text =
                    SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(
                        Date(
                            it.sys?.sunset?.toLong()?.times(1000) ?: 0L
                        )
                    )
                binding.wind.text = it.wind?.speed.toString()
            }
        }
    }
}
