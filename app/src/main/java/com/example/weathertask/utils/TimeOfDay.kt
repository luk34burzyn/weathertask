package com.example.weathertask.utils

import java.time.LocalDateTime

enum class TimeOfDay {
    MORNING, MID_DAY, NIGHT
}

fun whatTimeOfDay(thisTime: LocalDateTime):TimeOfDay {
    val whatADay = thisTime.toLocalDate()
    return if(thisTime.isBefore(whatADay.atTime(12, 0))
        && thisTime.isAfter(whatADay.atTime(5, 0))){
        TimeOfDay.MORNING
    } else if (thisTime.isBefore(whatADay.atTime(18,0))
        && thisTime.isAfter(whatADay.atTime(11, 59))
    ) TimeOfDay.MID_DAY
    else TimeOfDay.NIGHT
}