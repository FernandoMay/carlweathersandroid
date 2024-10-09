package tech.dsl.carlweathers.viewmodel

import androidx.lifecycle.ViewModel
import tech.dsl.carlweathers.domain.model.Location
import tech.dsl.carlweathers.domain.repository.LocationRepository
import tech.dsl.carlweathers.domain.repository.WeatherRepository

class WeatherViewModel(private val locationRepository: LocationRepository, private val weatherRepository: WeatherRepository) : ViewModel() {
    val locations = locationRepository.getLocations()

    fun fetchWeather(location: Location) {
        viewModelScope.launch {
            locationRepository.fetchWeather(location)
        }
    }

}