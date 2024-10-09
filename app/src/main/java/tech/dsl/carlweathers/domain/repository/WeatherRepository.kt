package tech.dsl.carlweathers.domain.repository

import tech.dsl.carlweathers.domain.model.Location
import tech.dsl.carlweathers.domain.model.Weather
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow

class WeatherRepository {
    private val weatherFlow = MutableStateFlow<Map<Location, Weather>>(emptyMap())

    fun getWeatherData(location: Location): Flow<Weather> = flow {
        val weatherData = weatherFlow.value[location]
        if (weatherData != null) {
            emit(weatherData)
        } else{
            val fetchedData = fetchWeatherFromApi(location)
            weatherFlow.value += (location to fetchedData)
            emit(fetchedData) // Emit fetched data
        }
    }

    private suspend fun fetchWeatherFromApi(location: Location): Weather {
        // Implement API call using Retrofit or similar library
        // Parse API response and return WeatherData object
        return Weather(temperature = 25.0, description = "Sunny", icon = "01d") // Example
    }
}