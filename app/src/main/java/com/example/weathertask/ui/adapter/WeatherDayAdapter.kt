package com.example.weathertask.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weathertask.R
import com.example.weathertask.databinding.ItemDayWeatherBinding


private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<WeatherItem>() {
    override fun areItemsTheSame(oldItem: WeatherItem, newItem: WeatherItem): Boolean =
        oldItem.day == newItem.day

    override fun areContentsTheSame(oldItem: WeatherItem, newItem: WeatherItem): Boolean =
        oldItem == newItem
}

class WeatherDayAdapter : ListAdapter<WeatherItem, WeatherTypeViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherTypeViewHolder {
        return WeatherTypeViewHolder(parent.inflate(R.layout.item_day_weather))
    }

    override fun onBindViewHolder(holder: WeatherTypeViewHolder, position: Int) =
        holder.bind(getItem(position)).apply {
            holder.itemView.setOnClickListener {  }
        }

}

class WeatherTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var binding : ItemDayWeatherBinding

    fun bind(item: WeatherItem) {
        binding = ItemDayWeatherBinding.bind(itemView)
        itemView.apply {

            binding.currentDayValue.text = item.day.toString()
            binding.mainTempValue.text = item.mainTemp.toString()
            binding.minTemperatureValue.text = item.minDayTemp.toString()
            binding.maxTemperatureValue.text = item.maxTemp.toString()
            binding.humidityValue.text = item.humidity.toString()

        }
    }
}

private fun ViewGroup.inflate(@LayoutRes layoutResId: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(this.context).inflate(layoutResId, this, attachToRoot)
